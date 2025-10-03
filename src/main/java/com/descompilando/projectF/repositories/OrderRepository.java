package com.descompilando.projectF.repositories;

import com.descompilando.projectF.entities.Order;
import com.descompilando.projectF.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
