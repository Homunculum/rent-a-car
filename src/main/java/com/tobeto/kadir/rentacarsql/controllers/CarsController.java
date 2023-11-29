package com.tobeto.kadir.rentacarsql.controllers;

import com.tobeto.kadir.rentacarsql.services.dtos.request.cars.AddCarsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.cars.UpdateCarsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.cars.GetCarsListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.cars.GetCarsResponse;
import com.tobeto.kadir.rentacarsql.entities.Cars;
import com.tobeto.kadir.rentacarsql.repositories.CarsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/cars")
public class CarsController {
    private final CarsRepository carsRepository;

    @GetMapping
    public List<GetCarsListResponse> getAll(){
        List<Cars> carsList = carsRepository.findAll();
        List<GetCarsListResponse> getCarsListResponses = new ArrayList<>();
        for (Cars cars: carsList) {
            GetCarsListResponse carsListResponse = new GetCarsListResponse();
            carsListResponse.setCarType(cars.getCarType());
            carsListResponse.setDailyPrice(cars.getDailyPrice());
            getCarsListResponses.add(carsListResponse);
        }

        return getCarsListResponses;
    }
    @GetMapping("{id}")
    public GetCarsResponse getById(@PathVariable int id) {
        Cars cars = carsRepository.findById(id).orElseThrow();

        GetCarsResponse getCarsResponse = new GetCarsResponse();
        getCarsResponse.setCarType(cars.getCarType());
        getCarsResponse.setDailyPrice(cars.getDailyPrice());

        return getCarsResponse;
    }
    @PostMapping
    public void add(@RequestBody AddCarsRequest addCarsRequest) {
        Cars cars = new Cars();
        cars.setCarType(addCarsRequest.getCarType());
        cars.setDailyPrice(addCarsRequest.getDailyPrice());

        carsRepository.save(cars);
    }

    @PutMapping
    public void update(@PathVariable int id, UpdateCarsRequest updateCarsRequest) {
        Cars cars = carsRepository.findById(id).orElseThrow();
        cars.setId(updateCarsRequest.getId());
        cars.setCarType(updateCarsRequest.getCarType());
        cars.setDailyPrice(updateCarsRequest.getDailyPrice());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Cars carsDelete = carsRepository.findById(id).orElseThrow();
        carsRepository.delete(carsDelete);
    }
}
