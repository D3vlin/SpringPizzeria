package com.d3vlin13.pizzeria.web.controller;

import com.d3vlin13.pizzeria.persistence.projection.IOrderSummary;
import com.d3vlin13.pizzeria.persistence.entity.OrderEntity;
import com.d3vlin13.pizzeria.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class Ordercontroller {
    private final OrderService orderService;

    @Autowired
    public Ordercontroller(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> findAll() {
        return ResponseEntity.ok(this.orderService.findAll());
    }

    @GetMapping("today")
    public ResponseEntity<List<OrderEntity>> getTodayOrders() {
        return ResponseEntity.ok(this.orderService.getTodayOrders());
    }

    @GetMapping("outside")
    public ResponseEntity<List<OrderEntity>> getOutsideOrders() {
        return ResponseEntity.ok(this.orderService.getOutsideOrders());
    }

    @GetMapping("customer/{idCustomer}")
    public ResponseEntity<List<OrderEntity>> findCustomerOrders(@PathVariable String idCustomer) {
        return ResponseEntity.ok(this.orderService.findCustomerOrders(idCustomer));
    }

    @GetMapping("summary/{idCustomer}")
    public ResponseEntity<IOrderSummary> getSummary(@PathVariable int idCustomer) {
        return ResponseEntity.ok(this.orderService.getSummary(idCustomer));
    }
}
