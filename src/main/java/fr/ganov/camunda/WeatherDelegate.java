package fr.ganov.camunda;

import fr.ganov.camunda.pojo.api.weather.Weather;
import fr.ganov.camunda.services.LocationEnum;
import fr.ganov.camunda.services.WeatherApiService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

/**
 *
 */
@Component("weatherAgent")
public class WeatherDelegate implements JavaDelegate {

    private final Logger logger = LogManager.getLogger(WeatherDelegate.class.getName());
    private static final SecureRandom random = new SecureRandom();

    @Autowired
    private WeatherApiService weatherApiService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String randomLoc = LocationEnum.values()[random.nextInt(LocationEnum.values().length)].label;
        logger.info("Hi! Weather in {} is :", randomLoc);

        Weather w = weatherApiService.getWeatherIn(randomLoc);
        Boolean weatherOk = Boolean.FALSE;
        if (w != null && w.getCurrent().getCondition().getCode() < 1004) {
            weatherOk = Boolean.TRUE;
        }

        delegateExecution.setVariable("city", randomLoc);
        delegateExecution.setVariable("weatherOk", weatherOk);
        delegateExecution.setVariable("weatherCondition", w.getCurrent().getCondition().getText());
    }
}
