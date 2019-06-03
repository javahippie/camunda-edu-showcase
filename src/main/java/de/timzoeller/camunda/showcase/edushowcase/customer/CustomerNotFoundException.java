package de.timzoeller.camunda.showcase.edushowcase.customer;

import org.camunda.bpm.engine.delegate.BpmnError;

public class CustomerNotFoundException extends BpmnError {

    CustomerNotFoundException(String message) {
        super(message);
    }
}
