package com.tobeto.kadir.rentacarsql.services.dtos.responses.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetModelsListResponse {
    private int modelYear;
    private String modelName;
}
