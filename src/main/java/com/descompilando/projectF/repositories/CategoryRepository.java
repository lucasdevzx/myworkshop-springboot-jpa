package com.descompilando.projectF.repositories;

import com.descompilando.projectF.entities.Category;
import com.descompilando.projectF.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
