package com.hutto.springstarter.services;

import com.hutto.springstarter.data.note.NoteEntity;
import com.hutto.springstarter.data.note.NoteRepository;
import com.hutto.springstarter.models.Filter;
import com.hutto.springstarter.models.Note;
import com.hutto.springstarter.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private NoteRepository noteRepository;

    @Autowired
    private MapperUtil mapper;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note getNoteByMongoId(String mongoId) {
        return null;
    }

    public List<Note> getNotes(Filter filter) {
        //TODO:: Handel No Notes
        //TODO:: Add Filter, Pagination, and Sorting
        List<NoteEntity> noteEntities = noteRepository.findAll();

        return mapper.factory.getMapperFacade().mapAsList(noteEntities, Note.class);
    }

    public Note getNote(String id) {
        //TODO:: Handel No Notes
        Optional noteOptional = noteRepository.findById(id);
        if (noteOptional.isPresent()) {
            return mapper.factory.getMapperFacade().map(noteOptional.get(), Note.class);
        }
        return null;
    }

    public Note saveNote(Note note) {
        //Set Defaults
        note.createDate = new Date();
        note.archived = note.archived != null ? note.archived : false;

        NoteEntity noteEntity = mapper.factory.getMapperFacade().map(note, NoteEntity.class);
        noteEntity = noteRepository.save(noteEntity);

        return mapper.factory.getMapperFacade().map(noteEntity, Note.class);
    }
}
