package com.workintech.S18D2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.workintech.S18D2.entity.Fruit;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {
    @Query("SELECT f FROM Fruit f ORDER BY f.price DESC")
    List<Fruit> getByPriceDesc();

    @Query("SELECT f FROM Fruit f ORDER BY f.price ASC")
    List<Fruit> getByPriceAsc();

    @Query("SELECT f FROM Fruit f WHERE f.name ILIKE %:name%")
    List<Fruit> searchByName(String name);

}