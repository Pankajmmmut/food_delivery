package com.test.FoodDelivery.service;

import com.test.FoodDelivery.model.Order;
import com.test.FoodDelivery.repository.ICustomerRepo;
import com.test.FoodDelivery.repository.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    IOrderRepo orderRepo;
    @Autowired
    ICustomerRepo customerRepo;

    public void placeOrder(Order order) {



        Integer customerId=order.getCustomer().getCustomerId();
        boolean ValidCustomer=customerRepo.existsById(customerId);

        if(ValidCustomer){
            orderRepo.save(order);
        }
        else {
            throw new IllegalStateException("Order data invalid");
        }
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}
