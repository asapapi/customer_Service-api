package com.mojica.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mojica.entities.Customer;
import com.mojica.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.mockito.Mockito.when;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc


public class restControllerTest {

    @Autowired
    MockMvc mvc;
    @MockBean
    CustomerService customerService;

    @Test
    void createCustomer() throws Exception {
        Customer customer = new Customer("Asahi", "computer is busted");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(customer);
        customer.setId(1L);

        when(customerService.createNewCustomer(ArgumentMatchers.any(Customer.class))).thenReturn(customer);
        mvc.perform(post("/api/customers").content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id")
                        .exists());

        when(customerService.createNewCustomer(ArgumentMatchers.any(Customer.class))).thenReturn(customer);
        mvc.perform(post("/api/customers").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());

    }
}
