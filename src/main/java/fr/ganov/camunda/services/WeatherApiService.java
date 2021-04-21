package fr.ganov.camunda.services;

import fr.ganov.camunda.pojo.api.weather.Weather;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@Component
@PropertySource("classpath:weatherApi.properties")
public class WeatherApiService {

    private final Logger logger = LogManager.getLogger(WeatherApiService.class.getName());

    @Value("${weatherApi.baseUrl}")
    private String baseUrl;
    @Value("${weatherApi.key}")
    private String key;
    @Value("${weatherApi.chosenApi}")
    private String api;

    public Weather getWeatherIn(String loc) throws IOException {
        String uri = "http://" + baseUrl + api + "?key=" + key + "&q=" + loc;
        HttpGet request = new HttpGet(uri);
        Weather w = new Weather();
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
                CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                logger.info(result);
                ObjectMapper om = new ObjectMapper();
                w = om.readValue(result, Weather.class);
            }
        }
        return w;
    }
}
