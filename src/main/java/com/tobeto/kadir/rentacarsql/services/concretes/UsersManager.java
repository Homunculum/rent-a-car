package com.tobeto.kadir.rentacarsql.services.concretes;

import com.tobeto.kadir.rentacarsql.entities.Users;
import com.tobeto.kadir.rentacarsql.repositories.UsersRepository;
import com.tobeto.kadir.rentacarsql.services.abstracts.UsersService;
import com.tobeto.kadir.rentacarsql.services.dtos.request.users.AddUsersRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.users.UpdateUsersRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.users.GetUsersListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.users.GetUsersResponse;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

public class UsersManager implements UsersService {
    private UsersRepository usersRepository;
    @Override
    public List<GetUsersListResponse> getAll() {
        List<Users> usersList = usersRepository.findAll();
        List<GetUsersListResponse> usersListResponses=new ArrayList<>();
        for (Users users: usersList) {
            GetUsersListResponse usersListResponse = new GetUsersListResponse();
            usersListResponse.setId(users.getId());
            usersListResponse.setFirstName(users.getFirstName());
            usersListResponse.setLastName(users.getLastName());
            usersListResponse.setAge(users.getAge());
            usersListResponse.setAddress(users.getAddress());
            usersListResponse.setPhone(users.getPhone());
            usersListResponse.setEmail(users.getEmail());

        }
        return usersListResponses;
    }

    @Override
    public GetUsersResponse getById(int id) {
        Users users = usersRepository.findById(id).orElseThrow();
        GetUsersResponse dto = new GetUsersResponse();
        dto.setFirstName(users.getFirstName());
        dto.setLastName(users.getLastName());
        dto.setAge(users.getAge());
        dto.setAddress(users.getAddress());
        dto.setPhone(users.getPhone());
        dto.setEmail(users.getEmail());

        return dto;
    }

    @Override
    public void add(AddUsersRequest addUserRequest) {
        Users users = new Users();
        users.setFirstName(addUserRequest.getFirstName());
        users.setLastName(addUserRequest.getLastName());
        users.setAge(addUserRequest.getAge());
        users.setAddress(addUserRequest.getAddress());
        users.setPhone(addUserRequest.getPhone());
        users.setEmail(addUserRequest.getEmail());
        usersRepository.save(users);

    }

    @Override
    public void update(UpdateUsersRequest updateUsersRequest) {
        Users users = usersRepository.findById(updateUsersRequest.getId()).orElseThrow();
        users.setFirstName(updateUsersRequest.getFirstName());
        users.setLastName(updateUsersRequest.getLastName());
        users.setAge(updateUsersRequest.getAge());
        users.setAddress(updateUsersRequest.getAddress());
        users.setPhone(updateUsersRequest.getPhone());
        users.setEmail(updateUsersRequest.getEmail());
        usersRepository.save(users);
    }

    @Override
    public void delete(int id) {
        usersRepository.deleteById(id);

    }
}
