package io.github.rafaelpeinado.teste_2.infrastructure.messaging;

import io.github.rafaelpeinado.teste_2.domain.enums.OrderStatus;
import io.github.rafaelpeinado.teste_2.domain.model.Order;
import io.github.rafaelpeinado.teste_2.infrastructure.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    @Autowired
    private OrderRepository orderRepository;

    @KafkaListener(topics = "order-topic", groupId = "test-group")
    public void onOrderReceived(Order order) {
        order.setStatus(OrderStatus.ENVIADO_TRANSPORTADORA);
        orderRepository.save(order);
    }
}
