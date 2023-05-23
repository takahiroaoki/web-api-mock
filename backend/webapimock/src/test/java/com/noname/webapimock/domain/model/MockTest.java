package com.noname.webapimock.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

import com.noname.webapimock.domain.model.entity.Mock;

public class MockTest {
    @Test
    void testConstructor() {
        Mock mock = new Mock();
        assertEquals("Mock", mock.getClass().getSimpleName());
    }

    @Test
    void testGetMockPath() {
        Mock mock = new Mock();
        // Not set yet
        assertEquals("", mock.getMockPath());
        // After setting
        mock.setMockPath("/test");
        assertEquals("/test", mock.getMockPath());
    }

    @Test
    void testSetMockPath()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Mock mock = new Mock().setMockPath("/test");
        Field mockPath = mock.getClass().getDeclaredField("mockPath");
        mockPath.setAccessible(true);
        assertEquals("/test", mockPath.get(mock).toString());
    }

    @Test
    void testGetMockName() {
        Mock mock = new Mock();
        // Not set yet
        assertEquals("", mock.getMockName());
        // After setting
        mock.setMockName("test");
        assertEquals("test", mock.getMockName());
    }

    @Test
    void testSetMockName()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Mock mock = new Mock().setMockName("test");
        Field mockName = mock.getClass().getDeclaredField("mockName");
        mockName.setAccessible(true);
        assertEquals("test", mockName.get(mock).toString());
    }

    @Test
    void testGetStatusCode() {
        Mock mock = new Mock();
        // Not set yet
        assertEquals(500, mock.getStatusCode());
        // After setting
        mock.setStatusCode(200);
        assertEquals(200, mock.getStatusCode());
    }

    @Test
    void testSetStatusCode()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Mock mock = new Mock().setStatusCode(200);
        Field statusCode = mock.getClass().getDeclaredField("statusCode");
        statusCode.setAccessible(true);
        assertEquals(200, (Integer) statusCode.get(mock));
    }

    @Test
    void testGetContentType() {
        Mock mock = new Mock();
        // Not set yet
        assertEquals("", mock.getContentType());
        // After setting
        mock.setContentType("application/json");
        assertEquals("application/json", mock.getContentType());
    }

    @Test
    void testSetContentType()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Mock mock = new Mock().setContentType("application/json");
        Field contentType = mock.getClass().getDeclaredField("contentType");
        contentType.setAccessible(true);
        assertEquals("application/json", contentType.get(mock).toString());
    }

    @Test
    void testGetResponseBody() {
        Mock mock = new Mock();
        // Not set yet
        assertEquals("", mock.getResponseBody());
        // After setting
        mock.setResponseBody("test");
        assertEquals("test", mock.getResponseBody());
    }

    @Test
    void testSetResponseBody()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Mock mock = new Mock().setResponseBody("test");
        Field responseBody = mock.getClass().getDeclaredField("responseBody");
        responseBody.setAccessible(true);
        assertEquals("test", responseBody.get(mock).toString());
    }
}
