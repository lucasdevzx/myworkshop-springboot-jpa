package com.descompilando.projectF.resources;

import com.descompilando.projectF.entities.Order;
import com.descompilando.projectF.entities.User;
import com.descompilando.projectF.services.OrderService;
import com.descompilando.projectF.services.UserService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Sinaliza que a classe é um recurso web que é implementado por um rest controller
@RequestMapping(value = "/orders") // Define um meio de acesso para o recurso implementado
public class OrderResource {

    @Autowired
    OrderService orderService;

    @GetMapping // Sinaliza que o méthodo responde uma requisição do tipo GET do https
    public ResponseEntity<List<Order>> findAll() {

        List<Order> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") // Sinaliza que o methodo responde uma requisição do tipo GET do https com parâmetro
    public ResponseEntity<Order> findById(@PathVariable Long id) { // Permite que o parâmetro do http se atribua ao objeto
        Order obj = orderService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}