package com.test.FoodDelivery.repository;

import com.test.FoodDelivery.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodRepo extends JpaRepository<Food,Integer> {
}
