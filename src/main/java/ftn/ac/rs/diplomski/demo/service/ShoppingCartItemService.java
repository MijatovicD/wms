package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.dto.ShoppingCartItemDTO;
import ftn.ac.rs.diplomski.demo.entity.Product;
import ftn.ac.rs.diplomski.demo.entity.ProductCard;
import ftn.ac.rs.diplomski.demo.entity.ShoppingCartItem;
import ftn.ac.rs.diplomski.demo.repository.ShoppingCartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ShoppingCartItemService {

    @Autowired
    private ShoppingCartItemRepository shoppingCartItemRepository;

    @Autowired
    private ProductCardService productCardService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCartItemService itemService;

    public List<ShoppingCartItem> findAll(){
        return shoppingCartItemRepository.findAll();
    }

    public ShoppingCartItem findById(Integer id){
        return shoppingCartItemRepository.getOne(id);
    }

    public ShoppingCartItem save(ShoppingCartItem shoppingCartItem){
        shoppingCartItemRepository.save(shoppingCartItem);
        return itemService.saveInCard(shoppingCartItem);
    }

    public List<ShoppingCartItem> findByUserId(Integer id){
        return shoppingCartItemRepository.findAllByUserId(id);
    }

    @Transactional
    public ShoppingCartItem saveInCard(ShoppingCartItem shoppingCartItemDTO){
        ShoppingCartItem item = shoppingCartItemRepository.getOne(shoppingCartItemDTO.getId());
        Product product = productService.getOne(item.getProduct().getId());
        ProductCard productCard = productCardService.findById(product.getId());

        if(productCard != null){
            if (shoppingCartItemDTO.getQuantity() > productCard.getTotalAmount()){
                return null;
            }
            productCard.setTotalAmount(productCard.getTotalAmount() - shoppingCartItemDTO.getQuantity());
            System.out.println("total amount " + productCard.getTotalAmount() + " dto " + shoppingCartItemDTO.getQuantity());
            productCardService.save(productCard);
        }

        return item;
    }
}
