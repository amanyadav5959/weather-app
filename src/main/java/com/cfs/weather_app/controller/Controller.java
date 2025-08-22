package com.cfs.weather_app.controller;


import com.cfs.weather_app.dto.Root;
import com.cfs.weather_app.dto.WeatherResponse;
import com.cfs.weather_app.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")


public class Controller {

    @Autowired
    private WeatherService service;

@GetMapping("/{city}")
    public String getWeatherData(@PathVariable String city){

        return service.test();
    }

    @GetMapping("/my/{city}")
    public WeatherResponse getWeather(@PathVariable String city){

    return service.getdata(city);
    }
}
