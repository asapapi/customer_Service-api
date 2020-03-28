package com.mojica.Repositories;

import com.mojica.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerServiceRepo extends JpaRepository<Customer, Long> {
}
