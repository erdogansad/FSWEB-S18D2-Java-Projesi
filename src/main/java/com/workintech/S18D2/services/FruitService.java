package com.workintech.S18D2.services;

import java.util.List;

import com.workintech.S18D2.entity.Fruit;

public interface FruitService {
    List<Fruit> findAll();

    List<Fruit> findAllByPriceDesc();

    List<Fruit> findAllByPriceAsc();

    List<Fruit> searchByName(String name);

    Fruit find(int id);

    Fruit save(Fruit fruit);

    void delete(Fruit fruit);

}
