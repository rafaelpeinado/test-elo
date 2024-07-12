package io.github.rafaelpeinado.teste_2.application.adapters.controllers;

import io.github.rafaelpeinado.teste_2.domain.model.Order;
import io.github.rafaelpeinado.teste_2.domain.ports.interfaces.OrderServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderServicePort orderService;

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

}
