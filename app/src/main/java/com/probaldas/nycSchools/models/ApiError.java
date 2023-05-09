package com.probaldas.nycSchools.models;

public class ApiError {
    private int statusCode;
    private String endpoint;
    private String message = "Unknown Error.";

    public int getStatusCode() {
        return statusCode;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getMessage() {
        return message;
    }
}
