package io.github.rafaelpeinado.teste_2.infrastructure.config;

import io.github.rafaelpeinado.teste_2.domain.adapters.services.OrderServiceImpl;
import io.github.rafaelpeinado.teste_2.domain.model.Order;
import io.github.rafaelpeinado.teste_2.domain.ports.interfaces.OrderServicePort;
import io.github.rafaelpeinado.teste_2.domain.ports.repositories.OrderRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class BeanConfiguration {

    @Bean
    OrderServicePort orderService(OrderRepositoryPort orderRepositoryPort, KafkaTemplate<String, Order> kafkaTemplate) {
        return new OrderServiceImpl(orderRepositoryPort, kafkaTemplate);
    }
}
