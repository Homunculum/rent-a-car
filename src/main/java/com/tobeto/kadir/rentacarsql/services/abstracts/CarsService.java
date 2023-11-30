package com.tobeto.kadir.rentacarsql.services.abstracts;

import com.tobeto.kadir.rentacarsql.services.dtos.request.cars.AddCarsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.cars.UpdateCarsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.cars.GetCarsListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.cars.GetCarsResponse;

import java.util.List;

public interface CarsService {
    List<GetCarsListResponse> getAll();
    GetCarsResponse getById(int id);
    void add (AddCarsRequest request);
    void update (int id, UpdateCarsRequest updateCar);
    void delete (int id);
}
