package io.github.rafaelpeinado.teste_2.domain.ports.interfaces;

import io.github.rafaelpeinado.teste_2.domain.model.Order;

import java.util.Optional;

public interface OrderServicePort {
    Order createOrder(Order order);

    Order getOrderById(String id);
}
