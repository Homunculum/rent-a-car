package com.tobeto.kadir.rentacarsql.services.dtos.request.brands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandsRequest {
    private int id;
    private String brandName;

}
