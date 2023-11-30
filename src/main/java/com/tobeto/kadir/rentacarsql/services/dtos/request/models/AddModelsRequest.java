package com.tobeto.kadir.rentacarsql.services.dtos.request.models;

import com.tobeto.kadir.rentacarsql.entities.Brands;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddModelsRequest {
    private int modelYear;
    private String modelName;
    private Brands brands;
}
