package com.tobeto.kadir.rentacarsql.services.concretes;

import com.tobeto.kadir.rentacarsql.entities.Cars;
import com.tobeto.kadir.rentacarsql.entities.Models;
import com.tobeto.kadir.rentacarsql.repositories.CarsRepository;
import com.tobeto.kadir.rentacarsql.repositories.ModelsRepository;
import com.tobeto.kadir.rentacarsql.services.abstracts.CarsService;
import com.tobeto.kadir.rentacarsql.services.dtos.request.cars.AddCarsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.cars.UpdateCarsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.cars.GetCarsListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.cars.GetCarsResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class CarsManager implements CarsService {

    private final CarsRepository carsRepository;
    private final ModelsRepository modelsRepository;

    @Override
    public List<GetCarsListResponse> getAll() {
        List<Cars> carsList = carsRepository.findAll();
        List<GetCarsListResponse> carsListResponses = new ArrayList<>();
        for (Cars cars: carsList) {
            GetCarsListResponse carsListResponse = new GetCarsListResponse();

            carsListResponse.setCarType(cars.getCarType());
            carsListResponse.setDailyPrice(cars.getDailyPrice());
            carsListResponse.setModels(cars.getModels().getModelName());
            carsListResponses.add(carsListResponse);
        }

        return carsListResponses;
    }
    @Override
    public List<GetCarsListResponse> search(String carType){

        return carsRepository.search(carType);
    }

    @Override
    public GetCarsResponse getById(int id) {
        Cars cars = carsRepository.findById(id).orElseThrow();
        GetCarsResponse dto = new GetCarsResponse();
        dto.setCarType(cars.getCarType());
        dto.setDailyPrice(cars.getDailyPrice());
        dto.setModelsName(cars.getModels().getModelName());
        return dto;
    }

    @Override
    public void add(AddCarsRequest request) {

        Models models = modelsRepository.findById(Integer.valueOf(request.getModelsId()))
                .orElseThrow(() -> new IllegalArgumentException("The specified model was not found"));

        Cars cars = new Cars();
        cars.setId(request.getId());
        cars.setDailyPrice(request.getDailyPrice());
        cars.setModels(models);
        cars.setCarType(request.getCarType());
        carsRepository.save(cars);

    }

    @Override
    public void update(int id, UpdateCarsRequest updateCar) {
        Models models = modelsRepository.findById(Integer.valueOf(updateCar.getModelsId()))
                .orElseThrow(() -> new IllegalArgumentException("The specified model was not found"));

        Cars carsUpdate = carsRepository.findById(id).orElseThrow();
        carsUpdate.setCarType(updateCar.getCarType());
        carsUpdate.setDailyPrice(updateCar.getDailyPrice());
        carsUpdate.setModels(models);
        carsRepository.save(carsUpdate);

    }

    @Override
    public void delete(int id) {
        carsRepository.deleteById(id);

    }
}
