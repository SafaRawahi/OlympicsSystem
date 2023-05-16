package com.example.demo.OlympicsProjects.Models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data

public class MedalStandings extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
     String country;
    Integer goldMedals;
    Integer silverMedals;
    Integer bronzeMedals;
    @ManyToOne
    @JoinColumn(name = "athlete_id", referencedColumnName = "id")
    Athletes athletes;

}
