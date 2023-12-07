package com.tobeto.kadir.rentacarsql.services.dtos.request.rentals;

import com.tobeto.kadir.rentacarsql.entities.Cars;
import com.tobeto.kadir.rentacarsql.entities.Users;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalsRequest {

    @Positive(message = "enter only positive")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Past(message = "Just enter the date as dd-mm-yyyy")
    @NotEmpty(message = "cannot be empty or null")
    private Date rentalDate;

    @NotEmpty(message = "cannot be empty or null")
    @Positive(message = "enter only positive")
    @Max(value = 2,message = "Enter the Car ID as a number between zero and two.")
    private int car;

    @Digits(integer = 2,fraction = 0, message = "You can only enter integers")
    @NotEmpty(message = "cannot be empty or null")
    @Positive(message = "enter only positive")
    @Max(value = 2,message = "Enter the User ID as a number between zero and two.")
    private int user;
}
