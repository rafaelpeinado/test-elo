package io.github.rafaelpeinado.teste_2.domain.ports.repositories;

import io.github.rafaelpeinado.teste_2.domain.model.Order;

public interface OrderRepositoryPort {
    Order findById(String id);
    Order save(Order order);
}
