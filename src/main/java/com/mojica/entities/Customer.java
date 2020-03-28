package com.mojica.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String customerName;
    @Column
    String customerAddress;
    @Column
    String phoneNumber;
    @Column
    String description;

    public Customer() {
    }

    public Customer(String customerName, String customerAddress, String phoneNumber, String description) {
    }

    public Customer(Long id, String customerName, String customerAddress, String phoneNumber, String description) {
        this.id = id;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    public Customer(String customerName, String description) {
        this.customerName = customerName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(customerName, customer.customerName) &&
                Objects.equals(customerAddress, customer.customerAddress) &&
                Objects.equals(phoneNumber, customer.phoneNumber) &&
                Objects.equals(description, customer.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, customerAddress, phoneNumber, description);
    }
}
