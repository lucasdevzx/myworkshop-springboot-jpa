package com.descompilando.projectF.services;

import com.descompilando.projectF.entities.Category;
import com.descompilando.projectF.entities.Product;
import com.descompilando.projectF.entities.User;
import com.descompilando.projectF.repositories.CategoryRepository;
import com.descompilando.projectF.repositories.ProductRepository;
import com.descompilando.projectF.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Declara a classe para o conteiner do framework
public class ProductService {

    @Autowired // Injeta a dependência do conteiner automaticamente
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }
}
