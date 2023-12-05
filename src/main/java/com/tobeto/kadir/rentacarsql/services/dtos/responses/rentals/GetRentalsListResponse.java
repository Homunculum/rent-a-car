package com.tobeto.kadir.rentacarsql.services.dtos.responses.rentals;

import com.tobeto.kadir.rentacarsql.entities.Cars;
import com.tobeto.kadir.rentacarsql.entities.Users;
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
    private int totalPrice;
    private Cars car;
    private Users user;

}
