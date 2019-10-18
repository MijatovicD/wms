package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.ProductDTO;
import ftn.ac.rs.diplomski.demo.entity.Product;
import ftn.ac.rs.diplomski.demo.entity.ProductCard;
import ftn.ac.rs.diplomski.demo.repository.ProductRepository;
import ftn.ac.rs.diplomski.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(value = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<Page<ProductDTO>> getAllPaged(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Page<Product> products = (Page<Product>) productService.findAllPaged(page, size);
        Page<ProductDTO> productDTOS = products.map(ProductDTO::new);

        return new ResponseEntity<Page<ProductDTO>>(productDTOS, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll(){
        List<Product> products = productService.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product p : products){
            productDTOS.add(new ProductDTO(p));
        }
        return new ResponseEntity<>(productDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<List<ProductDTO>> findByName(@PathVariable("name") String name){
        List<Product> products = productService.findAllByName(name);
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product p : products){
            productDTOS.add(new ProductDTO(p));
        }
        return new ResponseEntity<>(productDTOS, HttpStatus.OK);
    }
}
