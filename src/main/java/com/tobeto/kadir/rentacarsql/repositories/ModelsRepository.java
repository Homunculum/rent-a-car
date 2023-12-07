package com.tobeto.kadir.rentacarsql.repositories;


import com.tobeto.kadir.rentacarsql.entities.Models;
import com.tobeto.kadir.rentacarsql.services.dtos.responses.models.GetModelsListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModelsRepository extends JpaRepository <Models,Integer>{

    @Query("SELECT new com.tobeto.kadir.rentacarsql.services.dtos.responses.models.GetModelsListResponse(m.modelYear, m.modelName, m.brands.name) FROM Models m WHERE LOWER(m.modelName) LIKE CONCAT('%', LOWER(:modelName), '%')")
    List<GetModelsListResponse> findByModelNameLikeIgnoreCase(String modelName);
    List<Models> findByModelNameAndModelYear(String modelName, int modelYear);
}
