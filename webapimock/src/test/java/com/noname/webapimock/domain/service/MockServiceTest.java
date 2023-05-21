package com.noname.webapimock.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.noname.webapimock.domain.model.entity.Mock;
import com.noname.webapimock.domain.repository.MockRepository;

@TestInstance(value = Lifecycle.PER_CLASS)
public class MockServiceTest {
    @org.mockito.Mock
    private MockRepository mockRepository;

    @InjectMocks
    private MockService mockService;

    private AutoCloseable closeable;

    @BeforeAll
    void openMocks() {
        this.closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterAll
    void closeMocks() throws Exception {
        this.closeable.close();
    }

    @Test
    void testFindMockByMockPath() {
        // Invalid mock path
        String invalidMockPath = "invalid mock path";
        when(this.mockRepository.findById(invalidMockPath)).thenReturn(null);
        Optional<Mock> invalidMock = this.mockService.findMockByMockPath(invalidMockPath);
        assertEquals(null, invalidMock);

        // Valid mock path
        String validMockPath = "/test";
        Optional<Mock> expectedMock = Optional.ofNullable(
                new Mock()
                        .setMockPath(validMockPath)
                        .setMockName("test")
                        .setStatusCode(200)
                        .setContentType("test/html")
                        .setResponseBody("<p>test</p>"));
        when(this.mockRepository.findById(validMockPath)).thenReturn(expectedMock);
        Optional<Mock> validMock = this.mockService.findMockByMockPath(validMockPath);
        assertEquals(expectedMock, validMock);
    }

    @Test
    void testFindAllMocks() {
        List<Mock> expected = new ArrayList<Mock>();
        expected.add(new Mock().setMockPath("/test1").setMockName("test"));
        expected.add(new Mock().setMockPath("/test2").setStatusCode(200));
        expected.add(new Mock().setMockPath("/test3").setContentType("test/html"));
        expected.add(new Mock().setMockPath("/test4").setResponseBody("<p>test</p>"));
        when(this.mockRepository.findAll()).thenReturn(expected);
        List<Mock> result = this.mockService.findAllMocks();
        assertEquals(expected, result);
    }
}
