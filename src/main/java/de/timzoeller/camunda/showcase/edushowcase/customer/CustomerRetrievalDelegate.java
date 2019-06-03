package de.timzoeller.camunda.showcase.edushowcase.customer;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.spin.json.SpinJsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.camunda.spin.Spin.JSON;

@Component("customerRetrievalDelegate")
public class CustomerRetrievalDelegate implements JavaDelegate {

    private static final String VAR_CUSTOMER_NR = "customerNr";
    private static final String VAR_CUSTOMER = "customer";
    private static final String ERROR_MESSAGE = "Could not find customer with number ";

    @Autowired
    private CustomerService customerService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String customerNr = (String) delegateExecution.getVariable(VAR_CUSTOMER_NR);

        Optional<CustomerEntity> customerEntity = customerService.findByCustomerNumber(customerNr);

        if (customerEntity.isPresent()) {
            SpinJsonNode json = JSON(customerEntity.get());
            delegateExecution.setVariable(VAR_CUSTOMER, json);
        } else {
            throw new CustomerNotFoundException(ERROR_MESSAGE + customerNr);
        }
    }
}
