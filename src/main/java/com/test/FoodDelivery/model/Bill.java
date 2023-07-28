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
public class Bill {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer billId;
    private LocalDateTime billDate;
    private Double totalCost;
    private Integer totalItem;


    @OneToOne(cascade = CascadeType.ALL)
    private Order order;
}
