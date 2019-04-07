package com.hutto.springstarter.models.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hutto.springstarter.models.Note;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NoteCollection extends BaseCollection {

    public List<Note> notes;

    public NoteCollection() {
    }

    public NoteCollection(List<Note> notes) {
        this.notes = notes;
        this.count = notes != null ? notes.size() : 0;
    }

    public NoteCollection(List<Note> notes, Integer limit, Integer offset, Integer totalCount) {
        this.notes = notes;
        this.count = notes != null ? notes.size() : 0;
        this.limit = limit;
        this.offset = offset;
        this.totalCount = totalCount;
    }

}
