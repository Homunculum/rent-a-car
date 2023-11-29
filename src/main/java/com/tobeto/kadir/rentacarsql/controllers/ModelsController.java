package com.tobeto.kadir.rentacarsql.controllers;


import com.tobeto.kadir.rentacarsql.services.dtos.request.models.AddModelsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.models.UpdateModelsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.models.GetModelsListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.models.GetModelsResponse;
import com.tobeto.kadir.rentacarsql.entities.Models;
import com.tobeto.kadir.rentacarsql.repositories.ModelsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/models")
public class ModelsController {
    private final ModelsRepository modelsRepository;

    @GetMapping
    public List<GetModelsListResponse> getAll() {
        List<Models> modelsList = modelsRepository.findAll();
        List<GetModelsListResponse> getModelsListResponses = new ArrayList<>();
        for (Models models : modelsList) {
            GetModelsListResponse modelsListResponse = new GetModelsListResponse();
            modelsListResponse.setModelName(models.getModelName());
            modelsListResponse.setModelYear(models.getModelYear());
            getModelsListResponses.add(modelsListResponse);
        }
        return getModelsListResponses;
    }
    @GetMapping("{id}")
    public GetModelsResponse getById(@PathVariable int id) {

        Models models= modelsRepository.findById(id).orElseThrow();
        GetModelsResponse getModelsResponse = new GetModelsResponse();
        getModelsResponse.setModelName(models.getModelName());
        getModelsResponse.setModelYear(models.getModelYear());

        return getModelsResponse;
    }

    @PostMapping
    public void add(@RequestBody AddModelsRequest addModelsRequest) {
        Models models = new Models();
        models.setModelName(addModelsRequest.getModelName());
        models.setModelYear(addModelsRequest.getModelYear());

        modelsRepository.save(models);
    }

    @PutMapping
    public void update(@PathVariable int id, UpdateModelsRequest updateModelsRequest) {
        Models models = modelsRepository.findById(id).orElseThrow();
        models.setModelName(updateModelsRequest.getModelName());
        models.setModelYear(updateModelsRequest.getModelYear());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Models modelsDelete = modelsRepository.findById(id).orElseThrow();
        modelsRepository.delete(modelsDelete);
    }
}
