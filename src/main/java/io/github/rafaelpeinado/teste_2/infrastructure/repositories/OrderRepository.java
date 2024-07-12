package io.github.rafaelpeinado.teste_2.infrastructure.repositories;

import io.github.rafaelpeinado.teste_2.domain.model.Order;
import io.github.rafaelpeinado.teste_2.domain.ports.repositories.OrderRepositoryPort;
import io.github.rafaelpeinado.teste_2.infrastructure.entities.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Component
public class OrderRepository implements OrderRepositoryPort {

    @Autowired
    private MongoOrderRepository orderRepository;

    @Override
    public Order findById(String id) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(id);
        if (orderEntity.isPresent()) {
            return orderEntity.get().toOrder();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado.");
    }

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = new OrderEntity(order.getId(), order.getStatus());
        return orderRepository.save(orderEntity).toOrder();
    }
}
