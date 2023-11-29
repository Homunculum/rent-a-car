package com.tobeto.kadir.rentacarsql.services.dtos.responses.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetModelsResponse {
    private int modelYear;
    private String modelName;
}
