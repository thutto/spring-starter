package com.hutto.springstarter.data;

import com.hutto.springstarter.data.note.NoteRepository;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@Profile("!it-embedded")
@EnableMongoRepositories(basePackageClasses = NoteRepository.class)
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
