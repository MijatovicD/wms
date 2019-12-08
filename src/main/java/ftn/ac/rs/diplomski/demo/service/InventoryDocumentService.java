package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.dto.CommissionDocumentDTO;
import ftn.ac.rs.diplomski.demo.dto.InventoryCommissionDTO;
import ftn.ac.rs.diplomski.demo.dto.InventoryDocumentDTO;
import ftn.ac.rs.diplomski.demo.dto.InventoryItemDTO;
import ftn.ac.rs.diplomski.demo.entity.InventoryCommission;
import ftn.ac.rs.diplomski.demo.entity.InventoryDocument;
import ftn.ac.rs.diplomski.demo.entity.ProductCard;
import ftn.ac.rs.diplomski.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryDocumentService {

    @Autowired
    private InventoryDocumentRepository documentRepository;

    @Autowired
    private InventoryItemRepository itemRepository;

    @Autowired
    private InventoryCommissionRepository commissionRepository;

    @Autowired
    private CommissionDocumentRepository commissionDocumentRepository;

    @Autowired
    private ProductCardRepository cardRepository;

    public List<InventoryDocument> findAll(){
        return documentRepository.findAll();
    }

    public Page<InventoryDocument> findAllPaged(Integer page, Integer size){
        PageRequest pageReq = PageRequest.of(page, size);
        Page<InventoryDocument> documents = documentRepository.findAll(pageReq);

        return documents;
    }

    public InventoryDocument getOne(Integer id){
        return documentRepository.getOne(id);
    }

    public InventoryDocument save(InventoryDocument inventoryDocument){
        return documentRepository.save(inventoryDocument);
    }

    public List<InventoryItemDTO> getItems(Integer id){
        List<InventoryItemDTO> allDTO = itemRepository.findAll().stream().map(
                item -> new InventoryItemDTO(item)
        ).collect(Collectors.toList());
        List<InventoryItemDTO> items = new ArrayList<>();
        for (InventoryItemDTO i : allDTO){
            if(i.getInventoryDocumentDTO().getId() == id){
                items.add(i);
            }
        }
        return items;
    }

    public List<CommissionDocumentDTO> getCommissions(Integer id){
        List<CommissionDocumentDTO> allDTO = commissionDocumentRepository.findAll().stream().map(
                commission -> new CommissionDocumentDTO(commission)
        ).collect(Collectors.toList());Collectors.toList();
        List<CommissionDocumentDTO> commissions = new ArrayList<>();
        for (CommissionDocumentDTO c : allDTO){
            if(c.getInventoryDocumentDTO().getId() == id){
                commissions.add(c);
            }
        }

        return commissions;
    }

    @Transactional
    public boolean proknjizi(InventoryDocumentDTO inventoryDocumentDTO){
        System.out.println("ulazi?");
        List<InventoryItemDTO> itemDTOS = getItems(inventoryDocumentDTO.getId());

        for (InventoryItemDTO i : itemDTOS){
            ProductCard productCard = null;
            for (ProductCard p : i.getProductDTO().getProductCards()){
                if (p.getWarehouse().getId() == inventoryDocumentDTO.getWarehouse().getId()){
                    productCard = p;
                }
            }

//           if(productCard.getYear().isClose() == true && productCard.getTotalAmount() > 0){
               productCard.setInitStateOfQuantity((int) productCard.getTotalAmount());
               productCard.setInitStateOfValue(productCard.getTotalValue());
               productCard.setPrice(productCard.getPrice());
               productCard.setTrafficEntryQuantity(0);
               productCard.setTrafficEntryValue(0);
               productCard.setTrafficExitQuantity(0);
               productCard.setTrafficExitValue(0);
               cardRepository.save(productCard);

               inventoryDocumentDTO.setStatus("Proknjizen");
               Date date = new Date();
               inventoryDocumentDTO.setBookingDate(date);
               documentRepository.save(new InventoryDocument(inventoryDocumentDTO));
//           }
        }

        return false;
    }
}