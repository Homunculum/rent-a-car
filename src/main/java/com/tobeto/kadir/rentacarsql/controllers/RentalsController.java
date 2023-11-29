package com.tobeto.kadir.rentacarsql.controllers;

import com.tobeto.kadir.rentacarsql.services.dtos.request.rentals.AddRentalsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.rentals.UpdateRentalsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.rentals.GetRentalsListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.rentals.GetRentalsResponse;
import com.tobeto.kadir.rentacarsql.entities.Rentals;
import com.tobeto.kadir.rentacarsql.repositories.RentalsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/rentals")
public class RentalsController {
    private final RentalsRepository rentalsRepository;

    @GetMapping
    public List<GetRentalsListResponse> getAll() {
        List<Rentals> rentalsList = rentalsRepository.findAll();
        List<GetRentalsListResponse> getRentalsListResponses= new ArrayList<>();
        for (Rentals rentals: rentalsList
             ) {
            GetRentalsListResponse rentalsListResponse = new GetRentalsListResponse();
            rentalsListResponse.setRentalDate(rentals.getRentalDate());
            rentalsListResponse.setReturnDate(rentals.getReturnDate());
            getRentalsListResponses.add(rentalsListResponse);
        }
        return getRentalsListResponses;
    }

    @GetMapping("{id}")
    public GetRentalsResponse getById(@PathVariable int id) {
        Rentals rentals = rentalsRepository.findById(id).orElseThrow();
        GetRentalsResponse getRentalsResponse = new GetRentalsResponse();
        getRentalsResponse.setRentalDate(rentals.getRentalDate());
        getRentalsResponse.setReturnDate(rentals.getReturnDate());
        return getRentalsResponse;
    }

    @PostMapping
    public void add(@RequestBody AddRentalsRequest addRentalsRequest) {
        Rentals rentals=new Rentals();
        rentals.setRentalDate(addRentalsRequest.getRentalDate());
        rentals.setReturnDate(addRentalsRequest.getReturnDate());

        rentalsRepository.save(rentals);
    }

    @PutMapping
    public void update(@PathVariable int id, UpdateRentalsRequest updateRentalsRequest) {
       Rentals rentals= rentalsRepository.findById(id).orElseThrow();
       rentals.setId(updateRentalsRequest.getId());
       rentals.setRentalDate(updateRentalsRequest.getRentalDate());
       rentals.setReturnDate(updateRentalsRequest.getReturnDate());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Rentals rentalsDelete = rentalsRepository.findById(id).orElseThrow();
        rentalsRepository.delete(rentalsDelete);
    }
}
