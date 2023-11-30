package com.tobeto.kadir.rentacarsql.services.dtos.request.cars;

import com.tobeto.kadir.rentacarsql.entities.Models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarsRequest {
    private int id;
    private String carType;
    private int dailyPrice;
    private Models models;
}
