package com.example.demo.OlympicsProjects.Service;


import com.example.demo.OlympicsProjects.Models.Athletes;
import com.example.demo.OlympicsProjects.Models.Event;
import com.example.demo.OlympicsProjects.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServices {
    @Autowired
    EventRepository eventRepository;
    public List<Event> getAllEvents() {          //getAllEvents
        return eventRepository.getAllEvents();
    }

    public Event getEventsById(Integer id) {      //getEventsById
        Event event = eventRepository.getEventsById(id);
        return event;
    }
}
