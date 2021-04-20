package fr.ganov.camunda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 *
 */
@Component("weatherAgent")
public class WeatherDelegate implements JavaDelegate {

    private final Logger logger = LogManager.getLogger(WeatherDelegate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) {
        logger.info("Hi! WeatherAgent speaking.");
        delegateExecution.setVariable("name", "jeanjean");
        delegateExecution.setVariable("weatherOk", new Random().nextBoolean());
    }
}
