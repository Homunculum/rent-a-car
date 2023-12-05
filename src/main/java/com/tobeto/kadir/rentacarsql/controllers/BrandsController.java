package com.tobeto.kadir.rentacarsql.controllers;

import com.tobeto.kadir.rentacarsql.services.abstracts.BrandsService;
import com.tobeto.kadir.rentacarsql.services.dtos.request.brands.AddBrandsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.request.brands.UpdateBrandsRequest;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.brands.GetBrandsListResponse;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.brands.GetBrandsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/brands")
public class BrandsController {

    private final BrandsService brandsService;


    @GetMapping()
    public List<GetBrandsListResponse> getByName(@RequestParam String name)
    {
        return this.brandsService.getByName(name);
    }

  @GetMapping("getAll")
    public List<GetBrandsListResponse> getAll() {

        return brandsService.getAll();
    }

    @GetMapping("{id}")
    public GetBrandsResponse getById(@PathVariable int id) {

        return brandsService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddBrandsRequest request) {

        brandsService.add(request);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody UpdateBrandsRequest updateBrandsRequest) {
       brandsService.update(id, updateBrandsRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        brandsService.delete(id);
    }
}
