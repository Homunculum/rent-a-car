package com.tobeto.kadir.rentacarsql.services.dtos.responses.brands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetBrandsListResponse {
    private int id;
    private String brandName;
}
