package com.hutto.springstarter;

import com.hutto.springstarter.resources.NoteController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringStarterApplicationTests {

    @Autowired
    private NoteController noteController;

    @Test
    public void contextLoads() {
        assertNotNull("Note Controller Should not be Null", noteController);
    }

}
