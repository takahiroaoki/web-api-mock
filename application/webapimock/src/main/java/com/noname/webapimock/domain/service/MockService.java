package com.noname.webapimock.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noname.webapimock.domain.model.entity.Mock;
import com.noname.webapimock.domain.repository.MockRepository;

@Service
@Transactional
public class MockService {
    @Autowired
    private MockRepository mockRepository;

    MockService(MockRepository mockRepository) {
        this.mockRepository = mockRepository;
    }

    public Optional<Mock> findMockByMockPath(String mockPath) {
        return mockRepository.findById(mockPath);
    }

    public List<Mock> findAllMocks() {
        return mockRepository.findAll();
    }

    public Mock saveMock(Mock mock) {
        mockRepository.save(mock);
        return mock;
    }
}
