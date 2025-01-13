package com.superheros.ingrid.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.superheros.ingrid.entity.SuperheroEntity;
import com.superheros.ingrid.services.SuperheroService;

@RestController
@RequestMapping("/api/superheroes")
public class SuperheroController {

    private final SuperheroService superheroService;

    @Autowired
    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    @GetMapping
    public List<SuperheroEntity> getAllSuperheroes() {
        return superheroService.findAll();
    }

    @GetMapping("/{id}")
    public SuperheroEntity getSuperheroById(@PathVariable Long id) {
        return superheroService.findById(id);
    }

    @PostMapping
    public SuperheroEntity createSuperhero(@RequestBody  SuperheroEntity superhero) {
        return superheroService.save(superhero);
    }

    @PutMapping("/{id}")
    public SuperheroEntity updateSuperhero(@PathVariable Long id, @RequestBody  SuperheroEntity superhero) {
        superhero.setId(id); 
        return superheroService.save(superhero);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSuperhero(@PathVariable Long id) {
        superheroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}