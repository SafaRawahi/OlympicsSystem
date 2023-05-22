package com.example.demo.OlympicsProjects.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter

public class TopCountriesDTO {
    String country;
    Integer goldMedals;

    public TopCountriesDTO(String country, Integer goldMedals) {
        this.country = country;
        this.goldMedals = goldMedals;
    }
}
