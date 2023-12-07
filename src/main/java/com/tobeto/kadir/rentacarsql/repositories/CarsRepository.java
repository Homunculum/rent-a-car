package com.tobeto.kadir.rentacarsql.repositories;


import com.tobeto.kadir.rentacarsql.entities.Cars;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.cars.GetCarsListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarsRepository extends JpaRepository<Cars,Integer> {
    @Query("SELECT new com.tobeto.kadir.rentacarsql.services.dtos.responses.cars.GetCarsListResponse(c.carType, c.dailyPrice, c.models.modelName) "+
    "FROM Cars c WHERE c.carType LIKE %:carType%")
    List<GetCarsListResponse> search(String carType);



}
