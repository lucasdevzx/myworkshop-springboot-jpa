package com.descompilando.projectF.resources;

import com.descompilando.projectF.entities.Category;
import com.descompilando.projectF.entities.Product;
import com.descompilando.projectF.entities.User;
import com.descompilando.projectF.services.CategoryService;
import com.descompilando.projectF.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Sinaliza que a classe é um recurso web que é implementado por um rest controller
@RequestMapping(value = "/products") // Define um meio de acesso para o recurso implementado
public class ProductResource {

    @Autowired
    ProductService productService;

    @GetMapping // Sinaliza que o méthodo responde uma requisição do tipo GET do https
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = productService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") // Sinaliza que o methodo responde uma requisição do tipo GET do https com parâmetro
    public ResponseEntity<Product> findById(@PathVariable Long id) { // Permite que o parâmetro do http se atribua ao objeto
        Product obj = productService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}