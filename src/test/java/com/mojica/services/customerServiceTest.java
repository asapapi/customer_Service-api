package com.mojica.services;

import com.mojica.Repositories.CustomerServiceRepo;
import com.mojica.entities.Customer;
import com.mojica.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class customerServiceTest {

@Autowired
    CustomerServiceRepo customerServiceRepo;
// if no beans found nullpoint exception happens check project structure;

    @Test
    void createAndCustomer(){
        Customer customer = new Customer("Some Customer","I need this fix today");
        CustomerService customerService = new CustomerService(customerServiceRepo);
        assertNotNull(customerService.createNewCustomer(customer).getId());

    }

}
