package com.tobeto.kadir.rentacarsql.services.dtos.request.rentals;

import com.tobeto.kadir.rentacarsql.entities.Cars;
import com.tobeto.kadir.rentacarsql.entities.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalsRequest {
    private int id;
    private Date rentalDate;
    private Date returnDate;
    private int car;
    private int user;
}
