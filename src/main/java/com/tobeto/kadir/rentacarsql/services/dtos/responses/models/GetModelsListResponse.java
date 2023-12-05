package com.tobeto.kadir.rentacarsql.services.dtos.responses.models;

import com.tobeto.kadir.rentacarsql.entities.Brands;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetModelsListResponse {
    private int modelYear;
    private String modelName;
    private String brands;
}
