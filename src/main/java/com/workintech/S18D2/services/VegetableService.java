package com.workintech.S18D2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.workintech.S18D2.entity.Vegetable;

@Service
public interface VegetableService {
    List<Vegetable> findAll();

    List<Vegetable> findAllByPriceDesc();

    List<Vegetable> findAllByPriceAsc();

    List<Vegetable> searchByName(String name);

    Vegetable find(int id);

    Vegetable save(Vegetable vegetable);

    void delete(Vegetable vegetable);
}
