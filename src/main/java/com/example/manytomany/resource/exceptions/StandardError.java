package com.example.manytomany.resource.exceptions;

import java.time.Instant;

public class StandardError {

    private final Instant timestamp;
    private final Integer status;
    private final String error;
    private final String message;
    private final String path;

    public StandardError(
            Instant timestamp,
            Integer status,
            String error,
            String message,
            String path
    ) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
