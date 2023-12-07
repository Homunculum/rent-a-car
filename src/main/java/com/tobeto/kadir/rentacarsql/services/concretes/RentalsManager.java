package com.tobeto.kadir.rentacarsql.services.concretes;


import com.tobeto.kadir.rentacarsql.entities.Cars;
import com.tobeto.kadir.rentacarsql.entities.Rentals;
import com.tobeto.kadir.rentacarsql.entities.Users;
import com.tobeto.kadir.rentacarsql.repositories.CarsRepository;
import com.tobeto.kadir.rentacarsql.repositories.RentalsRepository;
import com.tobeto.kadir.rentacarsql.repositories.UsersRepository;
import com.tobeto.kadir.rentacarsql.services.abstracts.RentalsService;
import com.tobeto.kadir.rentacarsql.services.dtos.request.rentals.AddRentalsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.rentals.UpdateRentalsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.rentals.GetRentalsListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.rentals.GetRentalsResponse;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class RentalsManager implements RentalsService {
    private final RentalsRepository rentalsRepository;
    private final UsersRepository usersRepository;
    private final CarsRepository carsRepository;

    private void validateUnqieUserAndCar(int carsId){
        List<Rentals>  existingRental = rentalsRepository.findByCar_Id(carsId);
        if (existingRental != null) {
            throw new IllegalArgumentException("A car can only be rented by one user");
        }
    }
    @Override
    public List<GetRentalsListResponse> getAll() {
        List<Rentals> rentalsList = rentalsRepository.findAll();
        List<GetRentalsListResponse> rentalsListResponses = new ArrayList<>();

        for (Rentals rentals : rentalsList) {


            GetRentalsListResponse rentalsListResponse = new GetRentalsListResponse();
            rentalsListResponse.setRentalDate(rentals.getRentalDate());
            rentalsListResponse.setReturnDate(rentals.getReturnDate());
            rentalsListResponse.setUser(rentals.getUser().getId());
            rentalsListResponse.setCar(rentals.getCar().getId());

            // Hesaplama ve kontrol işlemleri
            if (rentals.getReturnDate() != null) {
                long rentalDays = ChronoUnit.DAYS.between(rentals.getRentalDate().toInstant(), rentals.getReturnDate().toInstant());
                Integer totalPrice = Math.toIntExact(rentalDays * rentals.getCar().getDailyPrice());
                rentalsListResponse.setTotalPrice(totalPrice);
            } else {
                rentalsListResponse.setTotalPrice(null);
                rentalsListResponse.setAdditionalMessage("The car hasn't come back yet");
            }

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

        Users users = usersRepository.findById(Integer.valueOf(request.getUser()))
                .orElseThrow(()-> new IllegalArgumentException("The specified user was not found"));
        Cars cars = carsRepository.findById(Integer.valueOf(request.getCar()))
                .orElseThrow(()-> new IllegalArgumentException("The specified user was not found"));

        validateUnqieUserAndCar(request.getCar());

        Rentals rentals = new Rentals();
        rentals.setRentalDate(request.getRentalDate());
        rentals.setUser(users);
        rentals.setCar(cars);
        rentalsRepository.save(rentals);
    }

    @Override
    public void update(int id, UpdateRentalsRequest updateRentals) {

        Users users = usersRepository.findById(Integer.valueOf(updateRentals.getUser()))
                .orElseThrow(()-> new IllegalArgumentException("The specified user was not found"));
        Cars cars = carsRepository.findById(Integer.valueOf(updateRentals.getCar()))
                .orElseThrow(()-> new IllegalArgumentException("The specified user was not found"));

        validateUnqieUserAndCar(updateRentals.getCar());

        Rentals rentalsUpdate = rentalsRepository.findById(id).orElseThrow();
        rentalsUpdate.setRentalDate(updateRentals.getRentalDate());
        rentalsUpdate.setReturnDate(updateRentals.getReturnDate());
        rentalsUpdate.setUser(users);
        rentalsUpdate.setCar(cars);
        rentalsRepository.save(rentalsUpdate);
    }

    @Override
    public void delete(int id) {
        rentalsRepository.deleteById(id);

    }


    @Override
    public List<Rentals> getRentalsReturnDate() {
        return rentalsRepository.findByReturnDateNotNull();
    }
}
