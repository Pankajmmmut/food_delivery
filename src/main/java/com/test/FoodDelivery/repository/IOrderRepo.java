package com.test.FoodDelivery.repository;

import com.test.FoodDelivery.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo extends JpaRepository<Order,Integer> {
}
