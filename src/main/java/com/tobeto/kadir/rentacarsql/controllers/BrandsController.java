package com.tobeto.kadir.rentacarsql.controllers;

import com.tobeto.kadir.rentacarsql.services.dtos.request.brands.AddBrandsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.brands.UpdateBrandsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.brands.GetBrandsListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.brands.GetBrandsResponse;
import com.tobeto.kadir.rentacarsql.entities.Brands;
import com.tobeto.kadir.rentacarsql.repositories.BrandsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/brands")
public class BrandsController {

    private final BrandsRepository brandsRepository;




    @GetMapping
    public List<GetBrandsListResponse> getAll() {

        List<Brands> brands = brandsRepository.findAll();
        List<GetBrandsListResponse> brandsResponseList = new ArrayList<>();

        for (Brands brand: brands) {
            GetBrandsListResponse brandsResponse = new GetBrandsListResponse();
            brandsResponse.setBrandName(brand.getBrandName());
            brandsResponseList.add(brandsResponse);
            
        }
        return brandsResponseList;
    }

    @GetMapping("{id}")
    public GetBrandsResponse getById(@PathVariable int id) {

        Brands brands = brandsRepository.findById(id).orElseThrow();
        GetBrandsResponse dto = new GetBrandsResponse();
        dto.setBrandName(brands.getBrandName());
        return dto;
    }

    @PostMapping
    public void add(@RequestBody AddBrandsRequest request) {

        Brands brands = new Brands();
        brands.setBrandName(request.getBrandName());
        brandsRepository.save(brands);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateBrandsRequest updateBrandsRequest) {
        Brands brands = new Brands();
        brandsRepository.findById(brands.getId()).orElseThrow();
        brands.setId(updateBrandsRequest.getId());
        brands.setBrandName(updateBrandsRequest.getBrandName());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Brands brandsDelete = brandsRepository.findById(id).orElseThrow();
        brandsRepository.delete(brandsDelete);
    }
}
