package com.tobeto.kadir.rentacarsql.services.dtos.request.users;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUsersRequest {
    private int id;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Just enter string")
    @NotEmpty(message = "cannot be empty or null")
    @Max(value = 20)
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Just enter string")
    @NotEmpty(message = "cannot be empty or null")
    @Max(value = 15)
    private String lastName;

    @Digits(integer = 2,fraction = 0, message = "You can only enter integers")
    @Positive(message = "enter only positive")
    @Max(value = 99, message = "Enter a maximum of 99 numbers")
    @Min(value = 18, message = "Enter at least 18 numbers")
    @NotEmpty(message = "cannot be empty or null")
    private int age;

    @Digits(integer = 11,fraction = 0, message = "You can only enter integers")
    @Positive(message = "enter only positive")
    @NotEmpty(message = "cannot be empty or null")
    @Size(min = 11, max = 11, message = "")
    private int phone;

    @NotEmpty(message = "cannot be empty or null")
    @Email(message = "enter email address")
    private String email;

    @NotEmpty(message = "cannot be empty or null")
    private String address;
}
