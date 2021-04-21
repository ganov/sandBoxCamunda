package fr.ganov.camunda.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeatherApiService {

    @Value("weatherApi.baseUrl")
    private String baseUrl;
    @Value("weatherApi.key")
    private String key;
    @Value("weatherApi.chosenApi")
    private String api;

    public Boolean getWeatherIn(String loc) {

        return true;
    }
}
