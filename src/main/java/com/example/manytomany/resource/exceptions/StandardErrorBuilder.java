package com.example.manytomany.resource.exceptions;

import java.time.Instant;

public class StandardErrorBuilder {

    private final Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardErrorBuilder() {
        this.timestamp = Instant.now();
    }

    public StandardErrorBuilder status(Integer status) {
        this.status = status;
        return this;
    }

    public StandardErrorBuilder error(String error) {
        this.error = error;
        return this;
    }

    public StandardErrorBuilder message(String message) {
        this.message = message;
        return this;
    }

    public StandardErrorBuilder path(String path) {
        this.path = path;
        return this;
    }

    public StandardError build() {
        return new StandardError(timestamp, status, error, message, path);
    }
}
