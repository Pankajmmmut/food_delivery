package com.test.FoodDelivery.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer customerId;
    private String fullName;
    private Integer age;
    @Pattern(regexp = "^[0-9]{10}$")
    private String mobileNumber;
    @Email
    @Column(unique = true)
    private String email;
    @NotEmpty
    private String password;


    @OneToOne(cascade = CascadeType.ALL)
    private Order order;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
