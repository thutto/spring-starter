package com.hutto.springstarter.resources;

import com.hutto.springstarter.data.note.NoteEntity;
import com.hutto.springstarter.models.FieldError;
import com.hutto.springstarter.models.Note;
import com.hutto.springstarter.models.validators.NoteValidator;
import com.hutto.springstarter.services.NoteService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/greeting")
    public @ResponseBody String greeting() {
        return "Hello World";
    }

    @GetMapping("/all")
    public @ResponseBody
    List<Note> getNotes() {
        return noteService.getNotes(null);
    }

    @PostMapping("")
    public @ResponseBody Note saveNote(@RequestBody @Valid Note note, BindingResult result) {
        System.out.println("note = " + note.toString());

        NoteValidator noteValidator = new NoteValidator();
        noteValidator.validate(note, result);
        if(result.hasErrors()) {
            note.fieldErrors = FieldError.buildFieldErrors(result.getAllErrors());;
            return note;
        }

        //TODO Replace With Mapper
        NoteEntity noteEntity = new NoteEntity(note.id, note.note, note.createDate, note.archived);

        System.out.println("noteEntity.toString() = " + noteEntity.toString());

        return new Note();
    }
}
