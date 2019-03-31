package com.hutto.springstarter.data.note;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository  extends MongoRepository<NoteEntity, String> {

}
