package com.tobeto.kadir.rentacarsql.services.concretes;


import com.tobeto.kadir.rentacarsql.entities.Rentals;
import com.tobeto.kadir.rentacarsql.repositories.RentalsRepository;
import com.tobeto.kadir.rentacarsql.services.abstracts.RentalsService;
import com.tobeto.kadir.rentacarsql.services.dtos.request.rentals.AddRentalsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.rentals.UpdateRentalsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.rentals.GetRentalsListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.rentals.GetRentalsResponse;

import java.util.ArrayList;
import java.util.List;

public class RentalsManager implements RentalsService {
    private RentalsRepository rentalsRepository;
    @Override
    public List<GetRentalsListResponse> getAll() {
        List<Rentals> rentalsList = rentalsRepository.findAll();
        List<GetRentalsListResponse> rentalsListResponses = new ArrayList<>();
        for (Rentals rentals: rentalsList) {
            GetRentalsListResponse rentalsListResponse = new GetRentalsListResponse();
            rentalsListResponse.setId(rentals.getId());
            rentalsListResponse.setRentalDate(rentals.getRentalDate());
            rentalsListResponse.setReturnDate(rentals.getReturnDate());
            rentalsListResponse.setUser(rentals.getUser());
            rentalsListResponse.setCar(rentals.getCar());
            rentalsListResponses.add(rentalsListResponse);
        }

        return rentalsListResponses;
    }

    @Override
    public GetRentalsResponse getById(int id) {
        Rentals rentals = rentalsRepository.findById(id).orElseThrow();
        GetRentalsResponse dto = new GetRentalsResponse();
        dto.setRentalDate(rentals.getRentalDate());
        dto.setReturnDate(rentals.getReturnDate());
        dto.setUser(rentals.getUser());
        dto.setCar(rentals.getCar());
        return dto;
    }

    @Override
    public void add(AddRentalsRequest request) {
        Rentals rentals = new Rentals();
        rentals.setRentalDate(request.getRentalDate());

        rentals.setUser(request.getUser());
        rentals.setCar(request.getCar());
        rentalsRepository.save(rentals);
    }

    @Override
    public void update(int id, UpdateRentalsRequest updateRentals) {
        Rentals rentals = new Rentals();
        rentals.setRentalDate(updateRentals.getRentalDate());
        rentals.setReturnDate(updateRentals.getReturnDate());
        rentals.setUser(updateRentals.getUser());
        rentals.setCar(updateRentals.getCar());
        rentalsRepository.save(rentals);
    }

    @Override
    public void delete(int id) {
        rentalsRepository.deleteById(id);

    }
}
