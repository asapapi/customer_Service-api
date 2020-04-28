package com.mojica.controllers;

import com.mojica.entities.Customer;
import com.mojica.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class customerController {
    CustomerService customerService;

    public customerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    ResponseEntity<Object> createCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.createNewCustomer(customer));
    }

    @GetMapping
    ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCostumers());
    }
}
