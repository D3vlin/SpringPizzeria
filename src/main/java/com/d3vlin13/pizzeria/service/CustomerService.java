package com.d3vlin13.pizzeria.service;

import com.d3vlin13.pizzeria.persistence.entity.CustomerEntity;
import com.d3vlin13.pizzeria.persistence.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final ICustomerRepository customerRepository;

    @Autowired
    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity findByPhone(String phone) {
        return this.customerRepository.findByPhone((phone));
    }
}
