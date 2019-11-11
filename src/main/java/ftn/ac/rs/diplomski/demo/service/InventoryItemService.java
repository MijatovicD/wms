package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.entity.InventoryItem;
import ftn.ac.rs.diplomski.demo.repository.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryItemService {

    @Autowired
    private InventoryItemRepository itemRepository;

    public List<InventoryItem> findAll(){
        return itemRepository.findAll();
    }
}
