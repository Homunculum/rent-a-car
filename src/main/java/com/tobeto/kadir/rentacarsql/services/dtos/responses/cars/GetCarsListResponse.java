package com.tobeto.kadir.rentacarsql.services.dtos.responses.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCarsListResponse {
    private String carType;
    private int dailyPrice;

}
