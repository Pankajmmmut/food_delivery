package com.test.FoodDelivery.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInOutput {
    private boolean SignUpStatus;
    private String SignUpMessage;
}
