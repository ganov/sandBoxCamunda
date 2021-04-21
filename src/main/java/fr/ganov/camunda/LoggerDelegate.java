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
        StringBuilder log = new StringBuilder(
                "\n\n Weather condition in " + execution.getVariable("city").toString() + " : " + execution
                        .getVariable("weatherCondition").toString());
        log.append("\n\n  ... LoggerDelegate invoked by ");
        log.append("\n\nprocessDefinitionId=");
        log.append(execution.getProcessDefinitionId());
        log.append(", \n\nactivtyId=");
        log.append(execution.getCurrentActivityId());
        log.append(", \n\nactivtyName=");
        log.append(execution.getCurrentActivityName());
        log.append(", \n\nprocessInstanceId=");
        log.append(execution.getProcessInstanceId());
        log.append(", \n\nbusinessKey=");
        log.append(execution.getProcessBusinessKey());
        log.append(", \n\nexecutionId=");
        log.append(execution.getId());
        log.append(" \n\n");
        logger.info(log);
    }
}
