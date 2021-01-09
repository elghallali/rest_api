package com.elghallali.api.service;

import com.elghallali.api.model.Address;
import com.elghallali.api.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomer();
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer deleteCustomer(Customer customer);
    Customer getCustomer(Long id);
    Customer findByUsername(String username);
    List<Customer> findByLastName(String lastName);
    List<Customer> findByAddress(Address address);
}
