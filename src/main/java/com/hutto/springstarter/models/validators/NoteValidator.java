package com.hutto.springstarter.models.validators;

import com.hutto.springstarter.models.Note;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NoteValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Note.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Note note = (Note) target;
        if(note.id == null) {
            errors.reject("req_id", "'id' is a required field.");
        }

        if(note.note == null) {
            errors.reject("req_note", "'note' is a required field.");
        }

        if(note.createDate != null) {
            errors.reject("forbidden_createDate", "Create date is a forbidden field");
        }
    }
}
