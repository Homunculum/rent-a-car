package com.tobeto.kadir.rentacarsql.services.dtos.responses.cars;

import com.tobeto.kadir.rentacarsql.entities.Models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarsResponse {
    private String carType;
    private int dailyPrice;
    private String modelsName;
}
