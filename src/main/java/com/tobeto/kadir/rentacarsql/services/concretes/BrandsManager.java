package com.tobeto.kadir.rentacarsql.services.concretes;

import com.tobeto.kadir.rentacarsql.entities.Brands;
import com.tobeto.kadir.rentacarsql.repositories.BrandsRepository;
import com.tobeto.kadir.rentacarsql.services.abstracts.BrandsService;
import com.tobeto.kadir.rentacarsql.services.dtos.request.brands.AddBrandsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.brands.UpdateBrandsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.brands.GetBrandsListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.brands.GetBrandsResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BrandsManager implements BrandsService {
    private final BrandsRepository brandsRepository;
    @Override
    public List<GetBrandsListResponse> getAll() {
        List<Brands> brandsList = brandsRepository.findAll();
        List<GetBrandsListResponse> getBrandsListResponses = new ArrayList<>();

        for (Brands brands: brandsList) {
            GetBrandsListResponse dto = new GetBrandsListResponse();
            dto.setId(brands.getId());
            dto.setBrandName(brands.getBrandName());
            getBrandsListResponses.add(dto);
        }
        return getBrandsListResponses;
    }

    @Override
    public GetBrandsResponse getById(int id) {
        Brands brands = brandsRepository.findById(id).orElseThrow();
        GetBrandsResponse dto = new GetBrandsResponse();
        dto.setBrandName(brands.getBrandName());
        return dto;
    }

    @Override
    public void add(AddBrandsRequest request) {
        Brands brands = new Brands();
        brands.setBrandName(request.getBrandName());
        brandsRepository.save(brands);
    }

    @Override
    public void update(int id, UpdateBrandsRequest updateBrands) {
        Brands existingBrands = brandsRepository.findById(id).orElseThrow();
        existingBrands.setBrandName(updateBrands.getBrandName());
        brandsRepository.save(existingBrands);
    }

    @Override
    public void delete(int id) {
        Brands deleteBrands = brandsRepository.findById(id).orElseThrow();
        deleteBrands.setId(deleteBrands.getId());
        brandsRepository.save(deleteBrands);
    }

}
