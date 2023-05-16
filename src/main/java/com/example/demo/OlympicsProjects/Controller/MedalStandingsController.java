package com.example.demo.OlympicsProjects.Controller;


import com.example.demo.OlympicsProjects.Models.Event;
import com.example.demo.OlympicsProjects.Models.MedalStandings;
import com.example.demo.OlympicsProjects.Service.MedalStandingsServices;
import com.example.demo.OlympicsProjects.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MedalStandingsController {
    @Autowired
    MedalStandingsServices medalStandingsServices;

    @Autowired
    SlackClient slackClient;

    @Scheduled(cron = "0 0/5 * * * *")
    @RequestMapping(value = "medals", method = RequestMethod.GET)       //getAllMedals
    public List<MedalStandings> getAllMedals(){
        List<MedalStandings> medalStandingsList = new ArrayList<>();
        medalStandingsList=medalStandingsServices.getAllMedals();
        for ( MedalStandings medalStandings : medalStandingsList){
            slackClient.sendMessage(medalStandings.getId().toString());
            slackClient.sendMessage(medalStandings.getCountry());
            slackClient.sendMessage(medalStandings.getBronzeMedals().toString());
            slackClient.sendMessage(medalStandings.getGoldMedals().toString());
            slackClient.sendMessage(medalStandings.getSilverMedals().toString());
            slackClient.sendMessage(medalStandings.getCreatedDate().toString());
            slackClient.sendMessage(medalStandings.getUpdatedDate().toString());
            slackClient.sendMessage(medalStandings.getIsActive().toString());
        }
        return medalStandingsList;
    }
}
