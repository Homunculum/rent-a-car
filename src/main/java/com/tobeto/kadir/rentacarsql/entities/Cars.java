package com.tobeto.kadir.rentacarsql.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cars")
@Entity
public class Cars {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "car_type")
    private String carType;

    @Column(name = "daily_price")
    private int dailyPrice;
   @ManyToOne
    @JoinColumn(name = "model_id")
    private Models models;

   @OneToMany(mappedBy = "car")
   @JsonIgnore
    private List<Rentals> rentals;

}
