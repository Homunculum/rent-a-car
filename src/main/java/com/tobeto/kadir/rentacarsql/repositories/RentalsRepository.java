package com.tobeto.kadir.rentacarsql.repositories;


import com.tobeto.kadir.rentacarsql.entities.Rentals;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalsRepository extends JpaRepository <Rentals,Integer>{
    List<Rentals> findByReturnDateNotNull();
    List<Rentals> findByCar_Id(int carsId);

}
