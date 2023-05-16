package com.example.demo.OlympicsProjects.Repository;


import com.example.demo.OlympicsProjects.Models.Athletes;
import com.example.demo.OlympicsProjects.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query(" SELECT e from Event e ")      //getAllEvents
    List<Event> getAllEvents();

    @Query(value = "SELECT e from Event e where e.id = :id")    //getEventsById
    Event getEventsById(Integer id);
}
