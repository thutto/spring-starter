package com.hutto.springstarter;

import com.hutto.springstarter.models.Note;
import com.hutto.springstarter.models.base.NoteCollection;
import com.hutto.springstarter.resources.NoteController;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.core.env.AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME;

@IfProfileValue(name = ACTIVE_PROFILES_PROPERTY_NAME, value = "it-embedded")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class NoteTest {

    @LocalServerPort
    private int port;

    @Autowired
    private NoteController noteController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void contextLoads() {
        assertNotNull("Note Controller Should not be Null", noteController);
        assertNotNull("Rest Template Should not be Null", restTemplate);
    }


    @Test
    public void testBaseGet() throws Exception {
        Assert.assertThat(this.restTemplate.getForObject(getBasePath() + "/greeting", String.class), CoreMatchers.containsString("Hello World"));
    }

    @Test
    public void testRest() throws Exception {

        //Add Note
        Note noteRequest = new Note();
        noteRequest.note = "Test From Unit";
        ResponseEntity<Note> noteResponse = this.restTemplate.postForEntity(getBasePath(), noteRequest, Note.class);
        assertNotNull("Adding a Note the Response should not be null", noteResponse);
        assertEquals("Response Code should be 201.", noteResponse.getStatusCode(), HttpStatus.CREATED);
        assertNotNull("Adding a Note the Response Body should not be null", noteResponse.getBody());
        assertNotNull("Adding a Note the Response body should be a note with a id", noteResponse.getBody().id);
        assertEquals("Adding a Note the Response body should be a note with the original message", noteResponse.getBody().note, noteRequest.note);
        assertEquals("Response Code should be 201.", noteResponse.getStatusCode(), HttpStatus.CREATED);

        // Get All Notes
        assertNotNull("Getting All Notes should not be null", this.restTemplate.getForObject(getBasePath() + "/all", NoteCollection.class).notes);

        // Get Created Note
        Note note = this.restTemplate.getForObject(getBasePath() + "/" + noteResponse.getBody().id, Note.class);
        assertNotNull("Getting Note should not be null", note);
        assertNotNull("Getting Note Id should not be null", note.id);
        assertEquals("Getting Note Id should not be the same as sent in", note.id, noteResponse.getBody().id);
        assertNotNull("Getting Note should not be null", note.note);
    }

    private String getBasePath() {
        return "http://localhost:" + port + "/note";
    }

}
