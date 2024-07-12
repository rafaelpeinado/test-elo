package io.github.rafaelpeinado.teste_2.infrastructure.entities;

import io.github.rafaelpeinado.teste_2.domain.enums.OrderStatus;
import io.github.rafaelpeinado.teste_2.domain.model.Order;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "orders")
public class OrderEntity {
    @MongoId
    private String id;
    private OrderStatus status;

    public Order toOrder() {
        return new Order(this.id, this.status);
    }
}
