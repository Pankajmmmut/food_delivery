package com.test.FoodDelivery.repository;

import com.test.FoodDelivery.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthToken extends JpaRepository<AuthenticationToken,Integer> {
}
