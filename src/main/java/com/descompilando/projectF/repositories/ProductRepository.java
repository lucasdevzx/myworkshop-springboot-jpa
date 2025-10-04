package com.descompilando.projectF.repositories;

import com.descompilando.projectF.entities.Category;
import com.descompilando.projectF.entities.Product;
import com.descompilando.projectF.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
