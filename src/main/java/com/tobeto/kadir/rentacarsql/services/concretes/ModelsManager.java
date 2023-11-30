package com.tobeto.kadir.rentacarsql.services.concretes;

import com.tobeto.kadir.rentacarsql.entities.Models;
import com.tobeto.kadir.rentacarsql.repositories.ModelsRepository;
import com.tobeto.kadir.rentacarsql.services.abstracts.ModelsService;
import com.tobeto.kadir.rentacarsql.services.dtos.request.models.AddModelsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.models.UpdateModelsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.models.GetModelsListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.models.GetModelsResponse;

import java.util.ArrayList;
import java.util.List;

public class ModelsManager implements ModelsService {
    private ModelsRepository modelsRepository;

    @Override
    public List<GetModelsListResponse> getAll() {
        List<Models> modelsList = modelsRepository.findAll();
        List<GetModelsListResponse> modelsListResponses = new ArrayList<>();
        for (Models models:
            modelsList ) {
            GetModelsListResponse modelListResponse = new GetModelsListResponse();
            modelListResponse.setId(models.getId());
            modelListResponse.setModelName(models.getModelName());
            modelListResponse.setModelYear(models.getModelYear());
            modelListResponse.setBrands(models.getBrands());
            modelsListResponses.add(modelListResponse);
        }
        return modelsListResponses;
    }

    @Override
    public GetModelsResponse getById(int id) {
        Models models = new Models();
        GetModelsResponse dto = new GetModelsResponse();
        dto.setModelYear(models.getModelYear());
        dto.setModelName(models.getModelName());
        dto.setBrands(models.getBrands());
        return dto;
    }

    @Override
    public void add(AddModelsRequest addModelsRequest) {
        Models models = new Models();
        models.setModelName(addModelsRequest.getModelName());
        models.setBrands(addModelsRequest.getBrands());
        models.setModelYear(models.getModelYear());
        modelsRepository.save(models);

    }

    @Override
    public void update(UpdateModelsRequest updateModelsRequest) {
        Models modelsUpdate = modelsRepository.findById(updateModelsRequest.getId()).orElseThrow();
        modelsUpdate.setModelYear(updateModelsRequest.getModelYear());
        modelsUpdate.setModelName(updateModelsRequest.getModelName());
        modelsUpdate.setBrands(updateModelsRequest.getBrands());
        modelsRepository.save(modelsUpdate);

    }

    @Override
    public void delete(int id) {
        modelsRepository.deleteById(id);

    }
}
