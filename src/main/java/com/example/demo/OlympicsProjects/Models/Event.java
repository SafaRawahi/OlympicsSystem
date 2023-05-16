package com.example.demo.OlympicsProjects.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Data
public class Event extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
     String name;
    Integer numbersOfAthletes;
    String sport;
    String medal;
    Date schedule;

     @ManyToOne
     @JoinColumn(name = "result_id", referencedColumnName = "id")
    Results results;

}
