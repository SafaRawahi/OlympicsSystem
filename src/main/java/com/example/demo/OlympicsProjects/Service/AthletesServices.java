package com.example.demo.OlympicsProjects.Service;

import com.example.demo.OlympicsProjects.Models.Athletes;
import com.example.demo.OlympicsProjects.Repository.AthletesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthletesServices {
    @Autowired
    AthletesRepository athletesRepository;

    public List<Athletes> getAllAthletes() {           //getAllAthletes

        return athletesRepository.getAllAthletes();
    }


    public Athletes getAthletesById(Integer id) {       //getAthletesById
        Athletes athletes = athletesRepository.getAthletesById(id);
        return athletes;
    }

    public Athletes getAthletesByName(String name) {          //getAthletesByName
      Athletes athletes = athletesRepository.getAthletesByName(name);
         return athletes;
    }
}
