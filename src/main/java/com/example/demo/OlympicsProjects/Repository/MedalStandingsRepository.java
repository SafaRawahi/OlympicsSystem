package com.example.demo.OlympicsProjects.Repository;


import com.example.demo.OlympicsProjects.DTO.TopCountriesDTO;
import com.example.demo.OlympicsProjects.Models.Event;
import com.example.demo.OlympicsProjects.Models.MedalStandings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface MedalStandingsRepository extends JpaRepository<MedalStandings, Integer> {

    @Query("SELECT m from MedalStandings m")            //getAllMedals
    List<MedalStandings> getAllMedals();

    @Query(value = "SELECT * FROM medal_standings ORDER BY gold_medals DESC", nativeQuery = true)            //getgoldMedals
    List<MedalStandings> getGoldMedals();
}
