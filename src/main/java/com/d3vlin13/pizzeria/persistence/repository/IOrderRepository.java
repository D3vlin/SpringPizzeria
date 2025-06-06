package com.d3vlin13.pizzeria.persistence.repository;

import com.d3vlin13.pizzeria.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrderRepository extends ListCrudRepository<OrderEntity, Integer> {
    List<OrderEntity> findAllByDateAfter(LocalDateTime localDateTime);
    List<OrderEntity> findAllByMethodIn(List<String> methods);
}
