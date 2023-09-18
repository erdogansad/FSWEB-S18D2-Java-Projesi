package com.workintech.S18D2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.workintech.S18D2.dao.VegetableRepository;
import com.workintech.S18D2.entity.Vegetable;

public class VegetableServiceImpl {
    private VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public List<Vegetable> findAllByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public List<Vegetable> findAllByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }

    @Override
    public Vegetable find(int id) {
        Optional<Vegetable> optionalVegetable = vegetableRepository.findById(id);
        if (optionalVegetable.isPresent()) {
            return optionalVegetable.get();
        }
        return null;
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public void delete(Vegetable vegetable) {
        vegetableRepository.delete(vegetable);

    }
}
