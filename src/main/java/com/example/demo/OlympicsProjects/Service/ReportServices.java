package com.example.demo.OlympicsProjects.Service;


import com.example.demo.OlympicsProjects.DTO.PerformanceOfTheOlympicsDTO;
import com.example.demo.OlympicsProjects.DTO.TopCountriesDTO;
import com.example.demo.OlympicsProjects.Models.Event;
import com.example.demo.OlympicsProjects.Models.MedalStandings;
import com.example.demo.OlympicsProjects.Repository.EventRepository;
import com.example.demo.OlympicsProjects.Repository.MedalStandingsRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Service
public class ReportServices {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    MedalStandingsRepository medalStandingsRepository;
    public static final String pathToReports = "C:\\Users\\user015\\Downloads\\OlympicsSystemReports";

    public String generatePerformanceOfTheOlympicsReport() throws FileNotFoundException, JRException {
        List<Event> eventList = eventRepository.getAllEvents();
        List<PerformanceOfTheOlympicsDTO> performanceOfTheOlympicsDTOS = new ArrayList<>();
        for (Event events : eventList) {
            String name = events.getName();
            Integer numbersOfAthletes = events.getNumbersOfAthletes();
            Date createdDate = events.getCreatedDate();
            Date updatedDate = events.getUpdatedDate();
            Boolean isActive = events.getIsActive();
            PerformanceOfTheOlympicsDTO performanceOfTheOlympicsDTO = new PerformanceOfTheOlympicsDTO(name, numbersOfAthletes, createdDate, updatedDate, isActive);
            performanceOfTheOlympicsDTOS.add(performanceOfTheOlympicsDTO);
        }

        File file = new File("C:\\Users\\user015\\Documents\\demo.OlympicsProjects\\demo.OlympicsProjects\\src\\main\\resources\\PerformanceOfTheOlympics.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(performanceOfTheOlympicsDTOS);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "MyName");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\PerformanceOfTheOlympics.pdf");
        return "Report generated : " + pathToReports + "\\PerformanceOfTheOlympics.pdf";

    }

    public String TopCountriesReport() throws JRException  {
     List<MedalStandings>  medalStandingsList= medalStandingsRepository.getgoldMedals();
     List<TopCountriesDTO> topCountriesDTOS=new ArrayList<>();
     for ( MedalStandings medals : medalStandingsList){
         String country = medals.getCountry();
         Integer goldMedals = medals.getGoldMedals();
         TopCountriesDTO topCountriesDTO = new TopCountriesDTO(country,goldMedals);
         topCountriesDTOS.add(topCountriesDTO);
     }

        File file = new File("C:\\Users\\user015\\Documents\\demo.OlympicsProjects\\demo.OlympicsProjects\\src\\main\\resources\\TopCountries.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(topCountriesDTOS);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "MyName");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\TopCountries.pdf");
        return "Report generated : " + pathToReports + "\\TopCountries.pdf";

    }
}
