package com.tobeto.kadir.rentacarsql.services.concretes;

import com.tobeto.kadir.rentacarsql.entities.Users;
import com.tobeto.kadir.rentacarsql.repositories.UsersRepository;
import com.tobeto.kadir.rentacarsql.services.abstracts.UsersService;
import com.tobeto.kadir.rentacarsql.services.dtos.request.users.AddUsersRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.users.UpdateUsersRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.users.GetUsersListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.users.GetUsersResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class UsersManager implements UsersService {
    private final UsersRepository usersRepository;



    @Override
    public List<GetUsersListResponse> getAll() {
        List<Users> usersList = usersRepository.findAll();
        List<GetUsersListResponse> usersListResponses = new ArrayList<>();
        for (Users users : usersList) {
            GetUsersListResponse usersListResponse = new GetUsersListResponse();
            usersListResponse.setFirstName(users.getFirstName());
            usersListResponse.setLastName(users.getLastName());
            usersListResponse.setAge(users.getAge());
            usersListResponse.setAddress(users.getAddress());
            usersListResponse.setPhone(users.getPhone());
            usersListResponse.setEmail(users.getEmail());
            usersListResponses.add(usersListResponse);

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
    private void validateUniqueFirstNameAndLastName(String firstName, String lastName) {
        List<Users>  existingUser = usersRepository.findByFirstNameAndLastName(firstName, lastName);
        if (existingUser != null) {
            throw new IllegalArgumentException("This name and surname combination is already in use.");
        }
    }

    private void validateAge(int age){
        if(age <18 || age >99){
            throw new IllegalArgumentException("Age must be between 18 and 99 years.");
        }
    }
    @Override
    public void add(AddUsersRequest addUserRequest) {
        validateUniqueFirstNameAndLastName(addUserRequest.getFirstName(), addUserRequest.getLastName());
        validateAge(addUserRequest.getAge());
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
    public void update(int id, UpdateUsersRequest updateUsersRequest) {
        validateUniqueFirstNameAndLastName(updateUsersRequest.getFirstName(), updateUsersRequest.getLastName());
        validateAge(updateUsersRequest.getAge());
        Users usersUpdate = usersRepository.findById(id).orElseThrow();
        usersUpdate.setFirstName(updateUsersRequest.getFirstName());
        usersUpdate.setLastName(updateUsersRequest.getLastName());
        usersUpdate.setAge(updateUsersRequest.getAge());
        usersUpdate.setAddress(updateUsersRequest.getAddress());
        usersUpdate.setPhone(updateUsersRequest.getPhone());
        usersUpdate.setEmail(updateUsersRequest.getEmail());
        usersRepository.save(usersUpdate);
    }

    @Override
    public void delete(int id) {
        usersRepository.deleteById(id);

    }


    @Override
    public List<GetUsersListResponse> getUsersByNames(String firstName, String lastName) {
        List<Users> usersList = usersRepository.findByFirstNameLikeIgnoreCaseAndLastNameLikeIgnoreCaseAllIgnoreCase("%" + firstName + "%", "%" + lastName + "%");
        List<GetUsersListResponse> response = new ArrayList<>();
        for (Users users : usersList) {
            response.add(new GetUsersListResponse(users.getFirstName(), users.getLastName(), users.getAge(), users.getPhone(), users.getEmail(), users.getAddress()));
        }
        return response;
    }

    @Override
    public List<Users> getUsersByAges(int ageStart, int ageEnd) {
        return usersRepository.findByAgeBetween(ageStart, ageEnd);
    }




}