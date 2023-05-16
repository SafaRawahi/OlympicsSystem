package com.example.demo.OlympicsProjects.Controller;


import com.example.demo.OlympicsProjects.Service.ReportServices;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.jar.JarException;

@RestController
@RequestMapping(value = "report")
public class ReportController {

    @Autowired
    ReportServices reportServices;

    @RequestMapping(value = "PerformanceOfTheOlympicsReport", method = RequestMethod.GET)
    public String generatePerformanceOfTheOlympicsReport() throws FileNotFoundException, JRException {
        return  reportServices.generatePerformanceOfTheOlympicsReport();
    }

    @RequestMapping(value = "TopCountriesReport", method = RequestMethod.GET)
    public String generateTopCountriesReport() throws FileNotFoundException, JRException {
        return  reportServices.TopCountriesReport();
    }

}
