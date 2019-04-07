package com.hutto.springstarter.resources;

import com.hutto.springstarter.models.Note;
import com.hutto.springstarter.models.base.Base;
import com.hutto.springstarter.models.base.FieldError;
import com.hutto.springstarter.models.base.NoteCollection;
import com.hutto.springstarter.models.validators.NoteValidator;
import com.hutto.springstarter.services.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/note")
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/greeting")
    public @ResponseBody
    String greeting() {
        return "Hello World";
    }

    @GetMapping("/all")
    public @ResponseBody
    ResponseEntity<?> getNotes() {
        return new ResponseEntity<NoteCollection>(new NoteCollection(noteService.getNotes(null)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity<?> getNote(@PathVariable String id) {
        if (id != null) {
            Note note = noteService.getNote(id);
            if (note != null) {
                return new ResponseEntity<Note>(noteService.getNote(id), HttpStatus.OK);
            }
        }
        // TODO:: Add message and return bad request
        return new ResponseEntity<Base>(new Base(), HttpStatus.NOT_FOUND);

    }

    @PostMapping()
    public @ResponseBody
    ResponseEntity<?> saveNote(@RequestBody @Valid Note note, BindingResult result) {
        NoteValidator noteValidator = new NoteValidator();
        noteValidator.validate(note, result);
        if (result.hasErrors()) {
            return new ResponseEntity<Base>(new Base(FieldError.buildFieldErrors(result.getAllErrors())), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Base>(noteService.saveNote(note), HttpStatus.CREATED);
    }
}
