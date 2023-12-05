package com.tobeto.kadir.rentacarsql.repositories;

import com.tobeto.kadir.rentacarsql.entities.Brands;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandsRepository extends JpaRepository<Brands,Integer> {
   List<Brands> findByNameLikeIgnoreCase(String name);



}
