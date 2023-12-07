package com.tobeto.kadir.rentacarsql.services.dtos.request.models;

import com.tobeto.kadir.rentacarsql.entities.Brands;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddModelsRequest {
    @Positive(message = "enter only positive")
    @Size(max = 4, min = 4,message = "enter only four numbers")
    private int modelYear;

    @NotEmpty(message = "cannot be empty or null")
    @Max(value = 12)
    private String modelName;

    @Digits(integer = 2,fraction = 0, message = "You can only enter integers")
    @NotEmpty(message = "cannot be empty or null")
    @Positive(message = "enter only positive")
    @Max(value = 2,message = "Enter the brand ID as a number between zero and two.")
    private int brands;
}
