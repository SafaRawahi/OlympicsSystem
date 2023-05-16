package com.example.demo.OlympicsProjects.Controller;


import com.example.demo.OlympicsProjects.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value= "register" )
public class GeneralController {
    @Autowired
    SlackClient slackClient;
    @GetMapping(value = "testUser")
    @PreAuthorize("hasRole('USER')")
    public String testForUser(){
        return "You are an user!";
    }

    @GetMapping("testAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public String testForAdmin() {
        return "You are an admin!";
    }
}
