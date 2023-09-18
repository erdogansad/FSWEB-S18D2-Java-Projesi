package com.workintech.S18D2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.S18D2.entity.Fruit;
import com.workintech.S18D2.exceptions.FruitException;
import com.workintech.S18D2.services.FruitService;

import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/fruit")
@Validated
public class FruitController {
    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/")
    public List<Fruit> get() {
        return fruitService.findAll();
    }

    @GetMapping("/{id}")
    public Fruit getById(@Positive @PathVariable int id) {
        Fruit fruit = fruitService.find(id);
        if (fruit == null) {
            throw new FruitException("Fruit with given id is not exist" + id, HttpStatus.BAD_REQUEST);
        }
        return fruit;
    }

    @GetMapping("/desc")
    public List<Fruit> getByPriceDesc() {
        return fruitService.findAllByPriceDesc();
    }

    @PostMapping("/")
    public Fruit save(@Validated @RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }// @validated ile validasyon işlemlerini burda uygula dedik, yada sınıfın en
     // üstüne yazılır

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable int id) {
        Fruit fruit = getById(id);
        fruitService.delete(fruit);
        return fruit;
    }

    @PostMapping("/{name}")
    public List<Fruit> searchByName(@PathVariable String name) {
        return fruitService.searchByName(name);
    }

}
