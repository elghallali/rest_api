package com.elghallali.api.repository;

import com.elghallali.api.model.Address;
import com.elghallali.api.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findByUsername(String username);
    List<Customer> findByLastName(String lastName);
    List<Customer> findByAddress(Address address);
}
