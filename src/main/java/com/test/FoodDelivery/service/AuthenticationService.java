package com.test.FoodDelivery.service;

import com.test.FoodDelivery.model.AuthenticationToken;
import com.test.FoodDelivery.repository.IAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthRepo authRepo;

    public boolean authenticate(String email,String authTokenValue){
        AuthenticationToken authToken = authRepo.findFirstByTokenValue(authTokenValue);

        if(authToken == null){
            return false;
        }

        String tokenConnectedEmail = authToken.getCustomer().getEmail();

        if(tokenConnectedEmail.equals(email)){
            return true;
        }
        else return false;
    }
}
