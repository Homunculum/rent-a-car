package com.tobeto.kadir.rentacarsql.services.abstracts;

import com.tobeto.kadir.rentacarsql.services.dtos.request.brands.AddBrandsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.brands.DeleteBrandsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.brands.UpdateBrandsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.brands.GetBrandsListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.brands.GetBrandsResponse;

import java.util.List;

public interface BrandsService {
    List<GetBrandsListResponse> getAll();
    GetBrandsResponse getById(int id);
    void add(AddBrandsRequest request);
    void update(int id, UpdateBrandsRequest updateBrands);
    void delete(int id, DeleteBrandsRequest deleteBrandsRequest);
}
