package com.mojica.services;

import com.mojica.Repositories.CustomerServiceRepo;
import com.mojica.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

@Autowired
            CustomerServiceRepo customerServiceRepo;


    public CustomerService() {
    }

    public CustomerService(CustomerServiceRepo customerServiceRepo) {
        this.customerServiceRepo = customerServiceRepo;
    }


    public Customer createNewCustomer(Customer customer) {
        customer.setId(customer.getId());
        return customerServiceRepo.save(customer);
    }

    public List getAllCostumers() {
        return  customerServiceRepo.findAll();
    }
}
