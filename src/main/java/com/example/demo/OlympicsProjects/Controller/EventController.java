package com.example.demo.OlympicsProjects.Controller;


import com.example.demo.OlympicsProjects.Models.Athletes;
import com.example.demo.OlympicsProjects.Models.Event;
import com.example.demo.OlympicsProjects.Service.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EventController {
    @Autowired
    EventServices eventServices;


    @RequestMapping(value = "getAllEvents", method = RequestMethod.GET)       //getAllEvents
    public List<Event> getAllEvents(){
        List<Event> eventList = new ArrayList<>();
        eventList=eventServices.getAllEvents();
        return eventList;
    }
    @RequestMapping(value = "getEventsById", method = RequestMethod.GET)    //getEventsById
    public Event getEventsById(@RequestParam Integer id){
        Event event = eventServices.getEventsById(id);
        return event;
    }

}
