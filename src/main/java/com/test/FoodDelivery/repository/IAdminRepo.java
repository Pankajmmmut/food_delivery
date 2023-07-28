package com.test.FoodDelivery.repository;

import com.test.FoodDelivery.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepo extends JpaRepository<Admin,Integer> {
}
