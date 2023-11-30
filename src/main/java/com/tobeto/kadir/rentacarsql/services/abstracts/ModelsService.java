package com.tobeto.kadir.rentacarsql.services.abstracts;

import com.tobeto.kadir.rentacarsql.services.dtos.request.models.AddModelsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.models.UpdateModelsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.models.GetModelsListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.models.GetModelsResponse;

import java.util.List;

public interface ModelsService {
    List<GetModelsListResponse> getAll();
    GetModelsResponse getById(int id);
    void add(AddModelsRequest addModelsRequest);
    void update(UpdateModelsRequest updateModelsRequest);
    void delete(int id);
}
