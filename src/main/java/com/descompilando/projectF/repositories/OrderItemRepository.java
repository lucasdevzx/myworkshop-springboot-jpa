package com.descompilando.projectF.repositories;

import com.descompilando.projectF.entities.OrderItem;
import com.descompilando.projectF.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
