package com.hutto.springstarter.data;

import com.github.fakemongo.Fongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@ComponentScan
@Configuration
@Profile("fongo")
public class FongoDatasource extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "fongo-test-db";
    }

    @Override
    @Bean
    public MongoClient mongoClient() {
        return new Fongo("Fongo").getMongo();
    }

}