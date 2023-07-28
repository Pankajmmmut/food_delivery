package com.test.FoodDelivery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer restaurantId;
    private String restaurantName;
    private String managerName;
    private String contactNumber;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

}
