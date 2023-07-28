package com.test.FoodDelivery.controller;

import com.test.FoodDelivery.model.Food;
import com.test.FoodDelivery.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {
    @Autowired
    FoodService foodService;

    @PostMapping("AddingFood")
    public String addFood(@RequestBody Food food){
        return foodService.addFood(food);
    }

    @GetMapping("foodList")
    public List<Food> getFoodList(){
        return foodService.getFoodList();
    }

    @DeleteMapping("food/{id}")
    public String deleteFoodbyId(@PathVariable Integer id){
        return foodService.deleteFoodbyId(id);

    }

}
