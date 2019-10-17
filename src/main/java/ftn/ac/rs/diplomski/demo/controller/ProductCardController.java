package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.ProductCardDTO;
import ftn.ac.rs.diplomski.demo.entity.Product;
import ftn.ac.rs.diplomski.demo.entity.ProductCard;
import ftn.ac.rs.diplomski.demo.service.ProductCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/productCard")
public class ProductCardController {

    @Autowired
    private ProductCardService productCardService;

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<Page<ProductCardDTO>> getAllPaged(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Page<ProductCard> cards = (Page<ProductCard>) productCardService.findAllPaged(page, size);
        Page<ProductCardDTO> companyDTOS = cards.map(ProductCardDTO::new);

        return new ResponseEntity<Page<ProductCardDTO>>(companyDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<List<ProductCardDTO>> findByProduct(@PathVariable("id") Integer id){
        List<ProductCard> productCards = productCardService.findAllByProductId(id);
        List<ProductCardDTO> productCardDTOS = new ArrayList<>();
        for (ProductCard p : productCards){
            productCardDTOS.add(new ProductCardDTO(p));
        }
        return new ResponseEntity<>(productCardDTOS, HttpStatus.OK);
    }
}
