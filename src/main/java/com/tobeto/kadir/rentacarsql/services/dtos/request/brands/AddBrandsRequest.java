package com.tobeto.kadir.rentacarsql.services.dtos.request.brands;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBrandsRequest {
    @NotEmpty(message = "cannot be empty or null")
    @Max(value = 12)
    private String brandName;
}
