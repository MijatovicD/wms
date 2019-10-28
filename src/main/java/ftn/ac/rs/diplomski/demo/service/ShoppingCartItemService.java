package ftn.ac.rs.diplomski.demo.service;

import com.fasterxml.jackson.databind.node.BigIntegerNode;
import ftn.ac.rs.diplomski.demo.dto.ShoppingCartItemDTO;
import ftn.ac.rs.diplomski.demo.entity.*;
import ftn.ac.rs.diplomski.demo.repository.ShoppingCartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
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
    private AnalyticsWarehouseCardService analyticsWarehouseCardService;

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

    @Transactional
    public ShoppingCartItem saveInCard(ShoppingCartItem shoppingCartItemDTO){
        ShoppingCartItem item = shoppingCartItemRepository.getOne(shoppingCartItemDTO.getId());
        Product product = productService.getOne(item.getProduct().getId());
        ProductCard productCard = productCardService.findByProductId(product.getId());

        System.out.println("product card " + productCard.toString());
        if(productCard != null){
            if (shoppingCartItemDTO.getQuantity() > productCard.getTotalAmount()){
                System.out.println("ako je null dal ulazi? ");
                return null;
            }
            System.out.println("total " + productCard.getTotalAmount() + "  kolicina " + shoppingCartItemDTO.getQuantity());
            productCard.setTotalAmount(productCard.getTotalAmount() - shoppingCartItemDTO.getQuantity());
            System.out.println("total amount " + productCard.getTotalAmount() + " dto " + shoppingCartItemDTO.getQuantity());
            productCardService.save(productCard);
            AnalyticsWarehouseCard a = analyticsWarehouseCardService.findByProducCardId(productCard.getId());

            AnalyticsWarehouseCard analytics = new AnalyticsWarehouseCard();
            analytics.setPrice(new BigDecimal(productCard.getPrice()));
            analytics.setQuantity(shoppingCartItemDTO.getQuantity());
            analytics.setProductCard(productCard);
            analytics.setDocumentItem(a.getDocumentItem());
            analytics.setTrafficDirectionEnum(AnalyticsWarehouseCard.TrafficDirectionEnum.I);
            analytics.setTrafficTypeDirectionEnum(AnalyticsWarehouseCard.TrafficTypeDirectionEnum.OT);
            BigInteger i = new BigInteger(String.valueOf(productCard.getPrice())).multiply(BigInteger.valueOf(shoppingCartItemDTO.getQuantity()));
            analytics.setValue(BigDecimal.valueOf(i.intValue()));
            analytics = analyticsWarehouseCardService.save(analytics);
            analytics.setSerialNumber(analytics.getId());
            analyticsWarehouseCardService.save(analytics);
        }

        return item;
    }
}
