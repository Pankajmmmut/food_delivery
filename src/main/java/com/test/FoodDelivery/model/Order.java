package com.test.FoodDelivery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer orderId;
    private LocalDateTime orderDate;
    private String orderStatus;


    @OneToOne
    private Customer customer;


    @OneToOne(cascade = CascadeType.ALL)
    private  Bill bill;
}
