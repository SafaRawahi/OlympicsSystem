package com.example.demo.OlympicsProjects.Service;


import com.example.demo.OlympicsProjects.Models.MedalStandings;
import com.example.demo.OlympicsProjects.Repository.MedalStandingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedalStandingsServices {
    @Autowired
    MedalStandingsRepository medalStandingsRepository;

    public List<MedalStandings> getAllMedals() {      //getAllMedals
        return medalStandingsRepository.getAllMedals();
    }
}
