package com.tobeto.kadir.rentacarsql.services.abstracts;

import com.tobeto.kadir.rentacarsql.services.dtos.request.users.AddUsersRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.users.UpdateUsersRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.users.GetUsersListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.users.GetUsersResponse;

import java.util.List;

public interface UsersService {
    List<GetUsersListResponse> getAll();
    GetUsersResponse getById(int id);
    void add(AddUsersRequest addUserRequest);
    void update(UpdateUsersRequest updateUsersRequest);
    void delete(int id);

}
