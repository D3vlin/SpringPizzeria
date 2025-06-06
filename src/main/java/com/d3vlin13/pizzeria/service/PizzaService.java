package com.d3vlin13.pizzeria.service;

import com.d3vlin13.pizzeria.persistence.entity.PizzaEntity;
import com.d3vlin13.pizzeria.persistence.repository.IPizzaPagSortRepository;
import com.d3vlin13.pizzeria.persistence.repository.IPizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    private final IPizzaRepository pizzaRepository;
    private final IPizzaPagSortRepository pizzaPagSortRepository;

    @Autowired
    public PizzaService(IPizzaRepository pizzaRepository, IPizzaPagSortRepository pizzaPagSortRepository) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaPagSortRepository = pizzaPagSortRepository;
    }

    public List<PizzaEntity> findAll() {
        return this.pizzaRepository.findAll();
    }

    public Page<PizzaEntity> findAllPag(int page, int elements) {
        Pageable pageRequest = PageRequest.of(page, elements);
        return this.pizzaPagSortRepository.findAll(pageRequest);
    }

    public List<PizzaEntity> findAvailable() {
        return this.pizzaRepository.findAllByAvailableTrueOrderByPrice();
    }

    public Page<PizzaEntity> findAvailablePag(int page, int elements, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageRequest = PageRequest.of(page, elements, sort);
        return this.pizzaPagSortRepository.findByAvailableTrue(pageRequest);
    }

    public PizzaEntity findByName(String name) {
        return this.pizzaRepository.findAllByAvailableTrueAndNameIgnoreCase(name);
    }

    public PizzaEntity findFirstByName(String name) {
        return this.pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase(name).orElseThrow(() -> new RuntimeException("La Pizza :" + name + ", no existe!"));
    }

    public List<PizzaEntity> findByWith(String description) {
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(description);
    }

    public List<PizzaEntity> findByWithout(String description) {
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(description);
    }

    public List<PizzaEntity> getCheapest(double price) {
        return this.pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
    }

    public PizzaEntity get(int idPizza) {
        return this.pizzaRepository.findById(idPizza).orElse(null);
    }

    public PizzaEntity save(PizzaEntity pizzaEntity) {
        return this.pizzaRepository.save(pizzaEntity);
    }

    public void deleteById(int idPizza) {
        this.pizzaRepository.deleteById(idPizza);
    }

    public boolean exists(int idPizza) {
        return this.pizzaRepository.existsById(idPizza);
    }
}
