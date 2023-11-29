package com.tobeto.kadir.rentacarsql.services.dtos.responses.rentals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalsListResponse {
    private Date rentalDate;
    private Date returnDate;

}
