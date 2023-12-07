package com.tobeto.kadir.rentacarsql.services.concretes;

import com.tobeto.kadir.rentacarsql.entities.Brands;
import com.tobeto.kadir.rentacarsql.entities.Models;
import com.tobeto.kadir.rentacarsql.entities.Users;
import com.tobeto.kadir.rentacarsql.repositories.BrandsRepository;
import com.tobeto.kadir.rentacarsql.repositories.ModelsRepository;
import com.tobeto.kadir.rentacarsql.services.abstracts.ModelsService;
import com.tobeto.kadir.rentacarsql.services.dtos.request.models.AddModelsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.models.UpdateModelsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.models.GetModelsListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.models.GetModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ModelsManager implements ModelsService {
    private final ModelsRepository modelsRepository;
    private final BrandsRepository brandsRepository;

    private void validateUniqueModelNameAndModelYear(String modelName, int modelYear) {
        List<Models>  existingModel = modelsRepository.findByModelNameAndModelYear(modelName, modelYear);
        if (existingModel != null) {
            throw new IllegalArgumentException("This name and year combination is already in use.");
        }
    }
    @Override
    public List<GetModelsListResponse> getAll() {
        List<Models> modelsList = modelsRepository.findAll();
        List<GetModelsListResponse> modelsListResponses = new ArrayList<>();
        for (Models models:
            modelsList ) {
            GetModelsListResponse modelListResponse = new GetModelsListResponse();
            modelListResponse.setModelName(models.getModelName());
            modelListResponse.setModelYear(models.getModelYear());
            modelListResponse.setBrands(models.getBrands().getName());
            modelsListResponses.add(modelListResponse);
        }
        return modelsListResponses;
    }

    @Override
    public GetModelsResponse getById(int id) {
        Models models = modelsRepository.findById(id).orElseThrow();
        GetModelsResponse dto = new GetModelsResponse();
        dto.setModelYear(models.getModelYear());
        dto.setModelName(models.getModelName());
        dto.setBrands(models.getBrands());
        return dto;
    }

    @Override
    public void add(AddModelsRequest addModelsRequest) {

        Brands brands = brandsRepository.findById(Integer.valueOf(addModelsRequest.getBrands())).
                orElseThrow(()-> new IllegalArgumentException("The specified brand was not found"));

        validateUniqueModelNameAndModelYear(addModelsRequest.getModelName(), addModelsRequest.getModelYear());

        Models models = new Models();
        models.setModelName(addModelsRequest.getModelName());
        models.setBrands(brands);
        models.setModelYear(models.getModelYear());
        modelsRepository.save(models);

    }

    @Override
    public void update(int id,UpdateModelsRequest updateModelsRequest) {
        Brands brands = brandsRepository.findById(Integer.valueOf(updateModelsRequest.getBrands())).
                orElseThrow(()-> new IllegalArgumentException("The specified brand was not found"));
        Models modelsUpdate = modelsRepository.findById(id).orElseThrow();
        modelsUpdate.setModelYear(updateModelsRequest.getModelYear());
        modelsUpdate.setModelName(updateModelsRequest.getModelName());
        modelsUpdate.setBrands(brands);
        modelsRepository.save(modelsUpdate);

    }
    
    @Override
    public void delete(int id) {
        modelsRepository.deleteById(id);

    }

    @Override
    public List<GetModelsListResponse> search(String modelName) {
        return modelsRepository.findByModelNameLikeIgnoreCase(modelName);
    }
}
