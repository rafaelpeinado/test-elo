package io.github.rafaelpeinado.teste_2.domain.adapters.services;

import io.github.rafaelpeinado.teste_2.domain.enums.OrderStatus;
import io.github.rafaelpeinado.teste_2.domain.model.Order;
import io.github.rafaelpeinado.teste_2.domain.ports.interfaces.OrderServicePort;
import io.github.rafaelpeinado.teste_2.domain.ports.repositories.OrderRepositoryPort;
import org.springframework.kafka.core.KafkaTemplate;

public class OrderServiceImpl implements OrderServicePort {

    private final OrderRepositoryPort orderRepository;
    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderServiceImpl(OrderRepositoryPort orderRepository, KafkaTemplate<String, Order> kafkaTemplate) {
        this.orderRepository = orderRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public Order createOrder(Order order) {
        order.setStatus(OrderStatus.AGUARDANDO_ENVIO);
        Order newOrder = orderRepository.save(order);
        kafkaTemplate.send("order-topic", newOrder.getId(), newOrder);
        return newOrder;
    }

    @Override
    public Order getOrderById(String id) {
        return orderRepository.findById(id);
    }
}
