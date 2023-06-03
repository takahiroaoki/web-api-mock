package com.noname.webapimock.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noname.webapimock.domain.model.constant.Path;
import com.noname.webapimock.domain.model.entity.Mock;
import com.noname.webapimock.domain.service.MockService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(Path.MOCK_BASE)
public class MockRestController {
    @Autowired
    MockService mockService;

    MockRestController(MockService mockService) {
        this.mockService = mockService;
    }

    @RequestMapping(path = "/**")
    String mockAction(HttpServletRequest request, HttpServletResponse response) {
        String mockPath = request.getRequestURI().substring(Path.MOCK_BASE.length());
        Mock mock = mockService
                .findMockByMockPath(mockPath)
                .orElse(
                        new Mock()
                                .setStatusCode(404)
                                .setContentType("text/html")
                                .setResponseBody(
                                        "<p>No mocks are registered on " + request.getRequestURI() + "</p>"));

        response.setStatus(mock.getStatusCode());
        response.setContentType(mock.getContentType());
        return mock.getResponseBody();
    }
}
