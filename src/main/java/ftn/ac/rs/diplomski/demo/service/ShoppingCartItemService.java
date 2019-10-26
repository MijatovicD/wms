package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.entity.ShoppingCartItem;
import ftn.ac.rs.diplomski.demo.repository.ShoppingCartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartItemService {

    @Autowired
    private ShoppingCartItemRepository shoppingCartItemRepository;

    public List<ShoppingCartItem> findAll(){
        return shoppingCartItemRepository.findAll();
    }

    public ShoppingCartItem findById(Integer id){
        return shoppingCartItemRepository.getOne(id);
    }

    public ShoppingCartItem save(ShoppingCartItem shoppingCartItem){
        return shoppingCartItemRepository.save(shoppingCartItem);
    }

    public List<ShoppingCartItem> findByUserId(Integer id){
        return shoppingCartItemRepository.findAllByUserId(id);
    }
}
