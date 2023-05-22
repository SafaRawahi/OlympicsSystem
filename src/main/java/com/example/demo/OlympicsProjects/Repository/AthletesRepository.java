package com.example.demo.OlympicsProjects.Repository;

import com.example.demo.OlympicsProjects.Models.Athletes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AthletesRepository extends JpaRepository<Athletes, Integer> {


    @Query(value = " SELECT a from Athletes a ")       //getAllAthletes
    List<Athletes> getAllAthletes();
    @Query(value = "SELECT a from Athletes a where a.id = :id")   //getAthletesById
    Athletes getAthletesById(Integer id);

    @Query(value = " SELECT a from Athletes a where a.name = :name")
    Athletes getAthletesByName(String name);

    @Query(value = " SELECT a from Athletes a where a.nationality = :nationality")     //getAthletesByNationality
    List<Athletes> getAthletesByNationality(String nationality);

    @Query(value = " SELECT a from Athletes a where a.sport = :sport")             //getAthletesBySport
    List<Athletes> getAthletesBySport(String sport);
}
