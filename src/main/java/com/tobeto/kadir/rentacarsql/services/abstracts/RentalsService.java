package com.tobeto.kadir.rentacarsql.services.abstracts;


import com.tobeto.kadir.rentacarsql.services.dtos.request.rentals.AddRentalsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.rentals.UpdateRentalsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.rentals.GetRentalsListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.rentals.GetRentalsResponse;

import java.util.List;

public interface RentalsService {
    List<GetRentalsListResponse> getAll();
    GetRentalsResponse getById(int id);
    void add(AddRentalsRequest request);
    void update(int id, UpdateRentalsRequest updateBrands);
    void delete(int id);
}
