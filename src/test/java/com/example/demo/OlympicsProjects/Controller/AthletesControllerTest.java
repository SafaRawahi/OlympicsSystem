package com.example.demo.OlympicsProjects.Controller;

import com.example.demo.OlympicsProjects.Models.Athletes;
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

    @Test
    void getAthletesByName() throws Exception  {
        Athletes athletesTest;
        athletesTest = athletesController.getAthletesByName("Nasser");
        int id = athletesTest.getId();
        assertEquals(3,id);
    }
    @Test
    void getAthletesByNameInvalid() throws Exception  {   //getAthletesByNameInvalid()
        Athletes athletesTest;
        athletesTest = athletesController.getAthletesByName("Nasser");
        int id = athletesTest.getId();
        assertNotEquals(2,id);
    }


}