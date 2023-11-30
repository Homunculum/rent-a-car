package com.tobeto.kadir.rentacarsql.services.dtos.responses.cars;

import com.tobeto.kadir.rentacarsql.entities.Models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCarsListResponse {
    private int id;
    private String carType;
    private int dailyPrice;
    private Models models;

}
