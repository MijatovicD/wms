package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService cartService;
}
