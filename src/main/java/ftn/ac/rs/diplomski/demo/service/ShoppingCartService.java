package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.entity.ShoppingCart;
import ftn.ac.rs.diplomski.demo.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public List<ShoppingCart> findAll(){
        return shoppingCartRepository.findAll();
    }

    public ShoppingCart findById(Integer id){
        return shoppingCartRepository.getOne(id);
    }

    public ShoppingCart save(ShoppingCart shoppingCart){
        return shoppingCartRepository.save(shoppingCart);
    }
}
