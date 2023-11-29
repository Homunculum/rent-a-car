package com.tobeto.kadir.rentacarsql.services.dtos.responses.rentals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalsResponse {
    private Date rentalDate;
    private Date returnDate;
}
