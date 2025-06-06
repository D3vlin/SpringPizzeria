package com.d3vlin13.pizzeria.web.controller;

import com.d3vlin13.pizzeria.persistence.entity.PizzaEntity;
import com.d3vlin13.pizzeria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaEntity>> findAll() {
        return ResponseEntity.ok(this.pizzaService.findAll());
    }

    @GetMapping("/page")
    public ResponseEntity<Page<PizzaEntity>> findAllPag(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int elements) {
        return ResponseEntity.ok(this.pizzaService.findAllPag(page, elements));
    }

    @GetMapping("/available")
    public ResponseEntity<List<PizzaEntity>> findAvailable() {
        return ResponseEntity.ok(this.pizzaService.findAvailable());
    }

    @GetMapping("/availablePag")
    public ResponseEntity<Page<PizzaEntity>> findAvailablePag(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int elements, @RequestParam(defaultValue = "price") String sortBy, @RequestParam(defaultValue = "ASC") String sortDirection) {
        return ResponseEntity.ok(this.pizzaService.findAvailablePag(page, elements, sortBy, sortDirection));
    }

    @GetMapping("/{idPizza}")
    public ResponseEntity<PizzaEntity> get(@PathVariable int idPizza) {
        return ResponseEntity.ok(this.pizzaService.get(idPizza));
    }

    @GetMapping("name/{name}")
    public ResponseEntity<PizzaEntity> findByName(@PathVariable String name) {
        return ResponseEntity.ok(this.pizzaService.findByName(name));
    }

    @GetMapping("firstName/{name}")
    public ResponseEntity<PizzaEntity> findFirstByName(@PathVariable String name) {
        return ResponseEntity.ok(this.pizzaService.findFirstByName(name));
    }

    @GetMapping("with/{description}")
    public ResponseEntity<List<PizzaEntity>> findByWith(@PathVariable String description) {
        return ResponseEntity.ok(this.pizzaService.findByWith(description));
    }

    @GetMapping("without/{description}")
    public ResponseEntity<List<PizzaEntity>> findByWithout(@PathVariable String description) {
        return ResponseEntity.ok(this.pizzaService.findByWithout(description));
    }

    @GetMapping("cheapest/{price}")
    public ResponseEntity<List<PizzaEntity>> findByWithout(@PathVariable double price) {
        return ResponseEntity.ok(this.pizzaService.getCheapest(price));
    }

    @PostMapping
    public ResponseEntity<PizzaEntity> save(@RequestBody PizzaEntity pizzaEntity) {
        if (pizzaEntity.getIdPizza() == null || !this.pizzaService.exists(pizzaEntity.getIdPizza())) {
            return ResponseEntity.ok(this.pizzaService.save(pizzaEntity));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<PizzaEntity> update(@RequestBody PizzaEntity pizzaEntity) {
        if (pizzaEntity.getIdPizza() != null && this.pizzaService.exists(pizzaEntity.getIdPizza())) {
            return ResponseEntity.ok(this.pizzaService.save(pizzaEntity));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idPizza}")
    public ResponseEntity<Void> deleteById(@PathVariable int idPizza) {
        if (this.pizzaService.exists(idPizza)) {
            this.pizzaService.deleteById(idPizza);
            ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
