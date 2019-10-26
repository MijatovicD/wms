package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.ShoppingCartDTO;
import ftn.ac.rs.diplomski.demo.entity.ShoppingCart;
import ftn.ac.rs.diplomski.demo.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/cart")
@CrossOrigin(value = "http://localhost:4200")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService cartService;

    @GetMapping
    public ResponseEntity<List<ShoppingCartDTO>> findAll(){
        List<ShoppingCart> carts = cartService.findAll();
        List<ShoppingCartDTO> dtos = new ArrayList<>();
        for (ShoppingCart c : carts){
            dtos.add(new ShoppingCartDTO(c));
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

}
