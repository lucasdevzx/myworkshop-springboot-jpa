package com.descompilando.projectF.services;

import com.descompilando.projectF.entities.Category;
import com.descompilando.projectF.entities.User;
import com.descompilando.projectF.repositories.CategoryRepository;
import com.descompilando.projectF.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Declara a classe para o conteiner do framework
public class CategoryService {

    @Autowired // Injeta a dependência do conteiner automaticamente
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }
}
