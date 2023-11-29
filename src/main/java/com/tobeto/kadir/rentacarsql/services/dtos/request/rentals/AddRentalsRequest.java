package com.tobeto.kadir.rentacarsql.services.dtos.request.rentals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalsRequest {
    private Date rentalDate;
    private Date returnDate;
}
