package ftn.ac.rs.diplomski.demo.controller;

import ftn.ac.rs.diplomski.demo.dto.AnalyticsWarehouseCardDTO;
import ftn.ac.rs.diplomski.demo.entity.AnalyticsWarehouseCard;
import ftn.ac.rs.diplomski.demo.service.AnalyticsWarehouseCardService;
import ftn.ac.rs.diplomski.demo.service.ProductCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/analytics")
@CrossOrigin(value = "http://localhost:4200")
public class AnalyticsWarehouseCardController {

    @Autowired
    private AnalyticsWarehouseCardService analyticsWarehouseCardService;

    @Autowired
    private ProductCardService productCardService;

    @GetMapping(value = {"", "/"}, params = {"page", "size"})
    public ResponseEntity<Page<AnalyticsWarehouseCardDTO>> getAllPaged(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        Page<AnalyticsWarehouseCard> cards = (Page<AnalyticsWarehouseCard>) analyticsWarehouseCardService.findAllPaged(page, size);
        Page<AnalyticsWarehouseCardDTO> analyticsWarehouseCardDTOS = cards.map(AnalyticsWarehouseCardDTO::new);

        return new ResponseEntity<Page<AnalyticsWarehouseCardDTO>>(analyticsWarehouseCardDTOS, HttpStatus.OK);
    }


    @GetMapping(value = "/productCard/{id}")
    public ResponseEntity<List<AnalyticsWarehouseCardDTO>> findByProdcutCardId(@PathVariable("id") Integer id){
        List<AnalyticsWarehouseCard> cards = analyticsWarehouseCardService.findByProdcutCardId(id);
        List<AnalyticsWarehouseCardDTO> dtos = new ArrayList<>();
        for (AnalyticsWarehouseCard a : cards){
            dtos.add(new AnalyticsWarehouseCardDTO(a));
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
