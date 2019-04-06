package com.hutto.springstarter.models;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class FieldError {
    public String field;
    public String errorCode;
    public String message;

    public FieldError() {
    }

    public FieldError(String field, String errorCode, String message) {
        this.field = field;
        this.errorCode = errorCode;
        this.message = message;
    }

    public static List<FieldError> buildFieldErrors(List<ObjectError> errors) {
        List<FieldError> fieldErrors = new ArrayList<>();

        for(ObjectError error: errors) {
            fieldErrors.add(new FieldError(error.getObjectName(), error.getCode(), error.getDefaultMessage()));
        }

        return fieldErrors;
    }

    @Override
    public String toString() {
        return "FieldError{" +
                "field='" + field + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
