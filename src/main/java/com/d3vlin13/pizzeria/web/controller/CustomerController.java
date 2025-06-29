package com.d3vlin13.pizzeria.web.controller;

import com.d3vlin13.pizzeria.persistence.entity.CustomerEntity;
import com.d3vlin13.pizzeria.persistence.entity.OrderEntity;
import com.d3vlin13.pizzeria.service.CustomerService;
import com.d3vlin13.pizzeria.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final OrderService orderService;

    public CustomerController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<CustomerEntity> findByPhone(@PathVariable String phone) {
        return ResponseEntity.ok(customerService.findByPhone(phone));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<OrderEntity>> findCustomerOrders(@PathVariable String id) {
        return ResponseEntity.ok(this.orderService.findCustomerOrders(id));
    }
}
