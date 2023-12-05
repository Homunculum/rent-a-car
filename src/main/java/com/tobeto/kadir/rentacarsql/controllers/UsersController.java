package com.tobeto.kadir.rentacarsql.controllers;

import com.tobeto.kadir.rentacarsql.entities.Users;
import com.tobeto.kadir.rentacarsql.services.abstracts.UsersService;
import com.tobeto.kadir.rentacarsql.services.dtos.request.users.AddUsersRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.users.UpdateUsersRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.users.GetUsersListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.users.GetUsersResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UsersController {
    private final UsersService usersService;

    @GetMapping
    public List<GetUsersListResponse> getAll() {
       return usersService.getAll();
    }

    @GetMapping("{id}")
    public GetUsersResponse getById(@PathVariable int id) {
        return usersService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddUsersRequest addUsersRequest) {
     usersService.add(addUsersRequest);
    }

    @PutMapping
    public void update(@PathVariable int id, UpdateUsersRequest updateUsersRequest) {
       usersService.update(id, updateUsersRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        usersService.delete(id);
    }
    @GetMapping("/search")
    public List<GetUsersListResponse> getUsersByNames(
            @RequestParam String firstName,
            @RequestParam String lastName) {
        return this.usersService.getUsersByNames(firstName, lastName);
    }

}
