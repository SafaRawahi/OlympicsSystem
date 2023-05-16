package com.example.demo.OlympicsProjects.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Data
@Setter
@Getter
public class PerformanceOfTheOlympicsDTO {
    String name;
    Integer numbersOfAthletes;
    @CreatedDate
    Date createdDate;
    @UpdateTimestamp
    Date updatedDate;
    Boolean isActive;

    public PerformanceOfTheOlympicsDTO(String name, Integer numbersOfAthletes, Date createdDate, Date updatedDate, Boolean isActive) {
        this.name = name;
        this.numbersOfAthletes = numbersOfAthletes;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.isActive = isActive;
    }
}
