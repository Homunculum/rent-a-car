package com.tobeto.kadir.rentacarsql.services.dtos.request.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUsersRequest {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private int phone;
    private String email;
    private String address;
}
