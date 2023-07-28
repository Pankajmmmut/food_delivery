package com.test.FoodDelivery.controller;

import com.test.FoodDelivery.model.Customer;
import com.test.FoodDelivery.model.dto.SignInInput;
import com.test.FoodDelivery.model.dto.SignUpOutput;
import com.test.FoodDelivery.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("customer/SignUp")
    public SignUpOutput signUpCustomer(@RequestBody @Valid Customer customer){
        return customerService.signUpCustomer(customer);
    }

    @PostMapping("customer/SignIn")
    public String signInCustomer(@RequestBody @Valid SignInInput signInInput){
        return customerService.signInCustomer(signInInput);
    }

    @GetMapping("customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("customer/{id}/{contact}")
    public String updateCustomerbyId(@PathVariable Integer id,@PathVariable String contact){
        return customerService.updateCustomerbyId(id,contact);
    }

    @DeleteMapping("customer/{id}")
    public String deleteCustomerbyId(@PathVariable Integer id){
        return customerService.deleteCustomerbyId(id);
    }

}
