package com.noname.webapimock.domain.model.form;

import java.io.Serializable;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class MockForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @Size(min = 1)
    private String mockPath;

    @Size(min = 1)
    private String mockName;

    @Min(100)
    @Max(599)
    private Integer statusCode;

    @Size(min = 1)
    private String contentType;

    @Size(min = 1)
    private String responseBody;

    public String getMockPath() {
        return this.mockPath;
    }

    public MockForm setMockPath(String mockPath) {
        this.mockPath = mockPath;
        return this;
    }

    public String getMockName() {
        return this.mockName;
    }

    public MockForm setMockName(String mockName) {
        this.mockName = mockName;
        return this;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public MockForm setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getContentType() {
        return this.contentType;
    }

    public MockForm setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public String getResponseBody() {
        return this.responseBody;
    }

    public MockForm setResponseBody(String responseBody) {
        this.responseBody = responseBody;
        return this;
    }
}