package io.github.rafaelpeinado.teste_2.domain.model;

import io.github.rafaelpeinado.teste_2.domain.enums.OrderStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String id;
    private OrderStatus status;
}
