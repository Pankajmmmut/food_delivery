package com.test.FoodDelivery.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer foodId;
    @NotEmpty
    private String foodName;
    private Category foodType;
    private Double price;
    private LocalTime processTime;

    @OneToMany
    List<Order> orderList;
}
