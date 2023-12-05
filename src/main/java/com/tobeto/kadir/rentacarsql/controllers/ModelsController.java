package com.tobeto.kadir.rentacarsql.controllers;


import com.tobeto.kadir.rentacarsql.services.abstracts.ModelsService;
import com.tobeto.kadir.rentacarsql.services.dtos.request.models.AddModelsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.models.UpdateModelsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.models.GetModelsListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.models.GetModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/models")
public class ModelsController {
    private final ModelsService modelsService;


    @GetMapping("searchName")
    public List<GetModelsListResponse> search (@RequestParam String modelName){
        return this.modelsService.search(modelName);
    }

    @GetMapping
    public List<GetModelsListResponse> getAll() {

        return modelsService.getAll();
    }
    @GetMapping("{id}")
    public GetModelsResponse getById(@PathVariable int id) {


        return modelsService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddModelsRequest addModelsRequest) {
       modelsService.add(addModelsRequest);
    }

    @PutMapping
    public void update(@PathVariable int id, UpdateModelsRequest updateModelsRequest) {
       modelsService.update(id, updateModelsRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
       modelsService.delete(id);
    }
}
