package com.test.FoodDelivery.repository;

import com.test.FoodDelivery.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthRepo extends JpaRepository<AuthenticationToken,Integer> {
    AuthenticationToken findFirstByTokenValue(String authTokenValue);
}
