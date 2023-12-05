package com.tobeto.kadir.rentacarsql.controllers;

import com.tobeto.kadir.rentacarsql.services.abstracts.CarsService;
import com.tobeto.kadir.rentacarsql.services.dtos.request.cars.AddCarsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.cars.UpdateCarsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.cars.GetCarsListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.cars.GetCarsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/cars")
public class CarsController {
    
    private final CarsService carsService;

    @GetMapping("searchType")
    public List<GetCarsListResponse> search (@RequestParam String carType){
        return this.carsService.search(carType);
    }
    @GetMapping
    public List<GetCarsListResponse> getAll(){

        return carsService.getAll();
    }
    @GetMapping("{id}")
    public GetCarsResponse getById(@PathVariable int id) {

        return carsService.getById(id);
    }
    @PostMapping
    public void add(@RequestBody AddCarsRequest addCarsRequest) {
       carsService.add(addCarsRequest);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, UpdateCarsRequest updateCarsRequest) {
        carsService.update(id, updateCarsRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        carsService.delete(id);
    }
}
