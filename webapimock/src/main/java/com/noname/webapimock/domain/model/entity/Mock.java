package com.noname.webapimock.domain.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mocks")
public class Mock {
    @Id
    @Column(name = "mock_path")
    private String mockPath;// The part after "/mock".

    @Column(name = "status_code")
    private int statusCode;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "response_body")
    private String responseBody;

    public String getMockPath() {
        return this.mockPath;
    }

    public Mock setMockPath(String mockPath) {
        this.mockPath = mockPath;
        return this;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public Mock setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getContentType() {
        return this.contentType;
    }

    public Mock setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public String getResponseBody() {
        return this.responseBody;
    }

    public Mock setResponseBody(String responseBody) {
        this.responseBody = responseBody;
        return this;
    }
}
