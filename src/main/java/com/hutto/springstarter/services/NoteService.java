package com.hutto.springstarter.services;

import com.hutto.springstarter.data.note.NoteEntity;
import com.hutto.springstarter.data.note.NoteRepository;
import com.hutto.springstarter.models.Filter;
import com.hutto.springstarter.models.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note getNoteByMongoId(String mongoId) {
        return null;
    }

    public List<Note> getNotes(Filter filter) {
        //TODO:: Add Filter, Pagination, and Sorting
        List<NoteEntity> noteEntities = noteRepository.findAll();
        List<Note> notes = mapNoteEntitesToNotes(noteEntities);

        return notes;

    }

    // TODO Replace with Ortika Mapper
    private List<Note> mapNoteEntitesToNotes(List<NoteEntity> noteEntities) {
        List<Note> notes = new ArrayList<>();
        if(noteEntities != null && !noteEntities.isEmpty()) {
            for (NoteEntity noteEntity: noteEntities) {
                Note note = mapNoteEntityToNote(noteEntity);
                if (note != null) {
                    notes.add(note);
                }

            }
        }

        return notes;
    }

    private Note mapNoteEntityToNote(NoteEntity noteEntity) {
        if(noteEntity != null) {
            Note note = new Note();
            note._id = noteEntity._id;
            note.id = noteEntity.id;
            note.note = noteEntity.note;
            note.createDate = noteEntity.createDate;
            note.archived = noteEntity.archived;
            return note;
        }
        return null;
    }

    private List<NoteEntity> mapNotesToNoteEntities(List<Note> notes) {
        List<NoteEntity> noteEntities = new ArrayList<>();
        if(notes != null && !notes.isEmpty()) {
            for (Note note: notes) {
                NoteEntity noteEntity = mapNoteToNoteEntity(note);
                if (note != null) {
                    noteEntities.add(noteEntity);
                }

            }
        }

        return noteEntities;
    }

    private NoteEntity mapNoteToNoteEntity(Note note) {
        if(note != null) {
            NoteEntity noteEntity = new NoteEntity();
            noteEntity._id = note._id;
            noteEntity.id = note.id;
            noteEntity.note = note.note;
            noteEntity.createDate = note.createDate;
            noteEntity.archived = note.archived;
            return noteEntity;
        }
        return null;
    }
}
