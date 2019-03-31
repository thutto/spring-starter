package com.hutto.springstarter.data;

import com.hutto.springstarter.data.note.NoteRepository;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = NoteRepository.class)
@Configuration
public class MongoDatasource extends AbstractMongoConfiguration {
    @Override
    protected String getDatabaseName() {
        return "test";
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient("localhost", 5555);
    }
}
