package fr.ganov.camunda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * This is an easy adapter implementation
 * illustrating how a Java Delegate can be used
 * from within a BPMN 2.0 Service Task.
 */
@Component("logger")
public class LoggerDelegate implements JavaDelegate {

    private final Logger logger = LogManager.getLogger(LoggerDelegate.class.getName());

    public void execute(DelegateExecution execution) {
        StringBuilder log = new StringBuilder("\n\n WeatherOk : " + execution.getVariable("weatherOk").toString());
        log.append("\n\n  ... LoggerDelegate invoked by ");
        log.append("processDefinitionId=");
        log.append(execution.getProcessDefinitionId());
        log.append(", activtyId=");
        log.append(execution.getCurrentActivityId());
        log.append(", activtyName=");
        log.append(execution.getCurrentActivityName());
        log.append(", processInstanceId=");
        log.append(execution.getProcessInstanceId());
        log.append(", businessKey=");
        log.append(execution.getProcessBusinessKey());
        log.append(", executionId=");
        log.append(execution.getId());
        log.append(" \n\n");
        logger.info(log);
    }
}
