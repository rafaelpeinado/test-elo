package io.github.rafaelpeinado.teste_2.infrastructure.repositories;

import io.github.rafaelpeinado.teste_2.infrastructure.entities.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoOrderRepository extends MongoRepository<OrderEntity, String> {
}
