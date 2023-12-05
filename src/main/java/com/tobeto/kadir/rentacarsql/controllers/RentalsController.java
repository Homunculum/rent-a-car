package com.tobeto.kadir.rentacarsql.controllers;

import com.tobeto.kadir.rentacarsql.services.abstracts.RentalsService;
import com.tobeto.kadir.rentacarsql.services.dtos.request.rentals.AddRentalsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.rentals.UpdateRentalsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.rentals.GetRentalsListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.rentals.GetRentalsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/rentals")
public class RentalsController {
    private final RentalsService rentalsService;

    @GetMapping
    public List<GetRentalsListResponse> getAll() {

        return rentalsService.getAll();
    }

    @GetMapping("{id}")
    public GetRentalsResponse getById(@PathVariable int id) {

        return rentalsService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddRentalsRequest addRentalsRequest) {
        rentalsService.add(addRentalsRequest);
    }

    @PutMapping
    public void update(@PathVariable int id, UpdateRentalsRequest updateRentalsRequest) {
      rentalsService.update(id, updateRentalsRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
       rentalsService.delete(id);
    }
}
