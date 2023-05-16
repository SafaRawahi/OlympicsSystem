package com.example.demo.OlympicsProjects.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Data
public class EventHistory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String eventName;
    String sport;

    @ManyToOne
    @JoinColumn(name = "athlete_id", referencedColumnName = "id")
    Athletes athletes;


}
