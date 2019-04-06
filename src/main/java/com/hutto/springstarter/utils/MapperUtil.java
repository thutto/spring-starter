package com.hutto.springstarter.utils;

import com.hutto.springstarter.data.note.NoteEntity;
import com.hutto.springstarter.models.Note;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MapperUtil {
    public MapperFactory factory;

    @PostConstruct
    public void init() {
        factory = new DefaultMapperFactory.Builder().build();
        factory.registerClassMap(factory.classMap(Note.class, NoteEntity.class)
                .field("id", "_id")
                .byDefault().toClassMap());

    }
}
