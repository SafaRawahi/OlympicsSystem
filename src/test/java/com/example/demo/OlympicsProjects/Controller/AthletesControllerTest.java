package com.example.demo.OlympicsProjects.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AthletesControllerTest {
    @Autowired
AthletesController athletesController;

    @Test
    void getAthletesById() throws Exception{
        String athleteName = athletesController.getAthletesById(1).getName();
        assertEquals("Ali",athleteName);
    }
    @Test
    void getAthletesByIdInvalid() throws Exception{
        String athleteName = athletesController.getAthletesById(2).getName();
        assertNotEquals("Ali",athleteName);
    }

}