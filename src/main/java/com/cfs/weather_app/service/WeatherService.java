package com.cfs.weather_app.service;


import com.cfs.weather_app.dto.Root;
import com.cfs.weather_app.dto.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.springframework.cglib.core.AbstractClassGenerator.getCurrent;

@Service
public class WeatherService {

    @Value("${Weather.api.key}")
    private String apikey;

    @Value("${Weather.api.url}")
    private String apiurl;

    private RestTemplate template =new RestTemplate();

    public String test(){
        return "good";
    }

    public WeatherResponse getdata(String city) {
        String url = apiurl + "?key="+apikey+"&q="+city;
        Root response = template.getForObject(url, Root.class);
        WeatherResponse weatherResponse=new WeatherResponse();


        weatherResponse.setCity(response.getLocation().name);
        weatherResponse.setRegion(response.getLocation().region);
        weatherResponse.setCountry(response.getLocation().country);
       String condition = response.getCurrent().getCondition().getText();
       weatherResponse.setCondition(condition);
weatherResponse.setTemperature(response.getCurrent().getTemp_c());

        return weatherResponse;

    }
}
