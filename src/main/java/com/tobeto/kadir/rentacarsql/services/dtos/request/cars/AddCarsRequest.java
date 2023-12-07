package com.tobeto.kadir.rentacarsql.services.dtos.request.cars;

import com.tobeto.kadir.rentacarsql.entities.Models;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarsRequest {
    @NotEmpty(message = "cannot be empty or null")
    private int id;

    @NotEmpty(message = "cannot be empty or null")
    private String carType;

    @Digits(integer = 2,fraction = 0, message = "You can only enter integers")
    @Positive(message = "cannot be zero or negative")
    @NotEmpty(message = "cannot be empty or null")
    private int dailyPrice;

    @Digits(integer = 2,fraction = 0, message = "You can only enter integers")
    @Positive(message = "cannot be zero or negative")
    @Max(value = 2,message = "Enter the Models ID as a number between zero and two.")
    private int modelsId;
}

