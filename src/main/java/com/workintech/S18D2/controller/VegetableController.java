package com.workintech.S18D2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.S18D2.entity.Vegetable;
import com.workintech.S18D2.services.VegetableService;

@RestController
@RequestMapping("/vegetable")
public class VegetableController {
    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping("/")
    public List<Vegetable> get() {
        return vegetableService.findAll();
    }

    @GetMapping("/{id}")
    public Vegetable getById(@PathVariable int id) {
        Vegetable vegetable = vegetableService.find(id);
        return vegetable;
    }

    @GetMapping("/desc")
    public List<Vegetable> getByPriceDesc() {
        return vegetableService.findAllByPriceDesc();
    }

    @PostMapping("/")
    public Vegetable save(@RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);

    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable int id) {
        Vegetable vegetable = getById(id);
        vegetableService.delete(vegetable);
        return vegetable;
    }

    @PostMapping("/{name}")
    public List<Vegetable> searchByName(@PathVariable String name) {
        return vegetableService.searchByName(name);
    }
}