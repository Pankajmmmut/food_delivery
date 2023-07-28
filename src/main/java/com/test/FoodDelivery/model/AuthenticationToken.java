package com.test.FoodDelivery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tokenId;
    private String tokenValue;
    private LocalDateTime creationDateTime;

    @OneToOne
    @JoinColumn(name = "fk_customer_id")
    Customer customer;

    public AuthenticationToken(Customer customer){
        this.customer=customer;
        this.tokenValue= UUID.randomUUID().toString();
        this.creationDateTime=LocalDateTime.now();
    }
}
