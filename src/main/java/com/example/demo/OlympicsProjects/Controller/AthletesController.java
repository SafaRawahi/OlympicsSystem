package com.example.demo.OlympicsProjects.Controller;


import com.example.demo.OlympicsProjects.Models.Athletes;
import com.example.demo.OlympicsProjects.Service.AthletesServices;
import com.example.demo.OlympicsProjects.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AthletesController {
    @Autowired
    AthletesServices athletesServices;
    @Autowired
    SlackClient slackClient;

       @RequestMapping(value = "getAll", method = RequestMethod.GET)       //getAllAthletes
    public List<Athletes> getAllAthletes(){
           List<Athletes> athletesList = new ArrayList<>();
           athletesList= athletesServices.getAllAthletes();
           return athletesList;
       }

    @RequestMapping(value = "getById", method = RequestMethod.GET)    //getAthletesById
    public Athletes getAthletesById(@RequestParam Integer id){
           Athletes athletes = athletesServices.getAthletesById(id);
           return athletes;
    }

    @RequestMapping(value = "getByName")
    public Athletes getAthletesByName(@RequestParam String name) {         //getAthletesByName
        Athletes athletes = athletesServices.getAthletesByName(name);
        return athletes;
    }
    @RequestMapping(value = "getByNationality")
    public List<Athletes> getAthletesByNationality(@RequestParam String nationality) {         //getAthletesByNationality
        List<Athletes> athletesList = new ArrayList<>();
        athletesList = athletesServices.getAthletesByNationality(nationality);
        return athletesList;
    }
}
