package com.test.FoodDelivery.controller;

import com.test.FoodDelivery.model.Order;
import com.test.FoodDelivery.service.AuthenticationService;
import com.test.FoodDelivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("Place/order")
    public String placeOrder(@RequestBody Order order,String email,String token){
        if(authenticationService.authenticate(email,token)){
            orderService.placeOrder(order);
            return "successfully placed order.";
        }
        else {
            return "invalid";
        }
    }

    @GetMapping("orders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
}
