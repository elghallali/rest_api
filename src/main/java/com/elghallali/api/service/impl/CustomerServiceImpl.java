package com.elghallali.api.service.impl;

import com.elghallali.api.model.Address;
import com.elghallali.api.model.Customer;
import com.elghallali.api.repository.CustomerRepository;
import com.elghallali.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer customerDB = customerRepository.findByUsername(customer.getUsername());
        if(customerDB!=null){
            return customerDB;
        }

        customer.setState("CREATED");
        customer.setCreateAt(new Date());
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer customerDB = this.getCustomer(customer.getId());
        if (customerDB==null){
            return null;
        }
        customerDB.setState("UPDATED");
        return customerRepository.save(customerDB);
    }

    @Override
    public Customer deleteCustomer(Customer customer) {
        Customer customerDB = this.getCustomer(customer.getId());
        if (customerDB==null){
            return null;
        }
        customer.setState("DELETED");
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    @Override
    public List<Customer> findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    @Override
    public List<Customer> findByAddress(Address address) {
        return customerRepository.findByAddress(address);
    }
}
