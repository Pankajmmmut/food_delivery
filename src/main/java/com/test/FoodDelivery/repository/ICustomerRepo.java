package com.test.FoodDelivery.repository;

import com.test.FoodDelivery.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer,Integer> {
    Customer findFirstByEmail(String newEmail);
}
