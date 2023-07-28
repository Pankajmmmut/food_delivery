package com.test.FoodDelivery.service;

import com.test.FoodDelivery.model.Food;
import com.test.FoodDelivery.repository.IFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    IFoodRepo foodRepo;

    public String addFood(Food food) {
        foodRepo.save(food);
        return "A food added : "+food.getFoodName();
    }

    public List<Food> getFoodList() {
        return foodRepo.findAll();
    }

    public String deleteFoodbyId(Integer id) {
        foodRepo.deleteById(id);
        return "deleted food id : "+id;
    }
}
