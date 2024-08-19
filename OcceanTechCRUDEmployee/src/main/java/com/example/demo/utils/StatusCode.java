package com.example.demo.utils;

public enum StatusCode {
    OK("200", "Success!"),
    CREATED("201", "Create successfully!"),
    BAD_REQUEST("400", "Data existed!"),
    NOT_FOUND("404", "Not found data!"),
    ;

    private final String code;
    private final String message;

    StatusCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
