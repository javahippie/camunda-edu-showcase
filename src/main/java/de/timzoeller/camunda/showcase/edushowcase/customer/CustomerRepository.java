package de.timzoeller.camunda.showcase.edushowcase.customer;

import org.springframework.data.repository.Repository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface CustomerRepository extends Repository<CustomerEntity, Long> {

    Optional<CustomerEntity> findByCustomerNumber(String customerNumber);
}
