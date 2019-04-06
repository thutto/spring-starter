package com.hutto.springstarter.models.base;

import java.util.List;

public class Base {
    public List<FieldError> fieldErrors;

    public Base() {
    }

    public Base(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

}
