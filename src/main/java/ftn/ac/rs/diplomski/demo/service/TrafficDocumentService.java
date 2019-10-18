package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.dto.DocumentItemDTO;
import ftn.ac.rs.diplomski.demo.dto.TrafficDocumentDTO;
import ftn.ac.rs.diplomski.demo.entity.AnalyticsWarehouseCard;
import ftn.ac.rs.diplomski.demo.entity.DocumentItem;
import ftn.ac.rs.diplomski.demo.entity.ProductCard;
import ftn.ac.rs.diplomski.demo.entity.TrafficDocument;
import ftn.ac.rs.diplomski.demo.repository.DocumentRepository;
import ftn.ac.rs.diplomski.demo.repository.ProductCardRepository;
import ftn.ac.rs.diplomski.demo.repository.TrafficDocumentItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrafficDocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private TrafficDocumentItemRepository documentItemRepository;

    @Autowired
    private ProductCardRepository cardRepository;

    public TrafficDocument getDocument(Integer id){

        return documentRepository.findById(id).get();
    }

    public Page<TrafficDocument> findAllPaged(Integer page, Integer size){
        PageRequest pageReq = PageRequest.of(page, size);
        Page<TrafficDocument> documents = documentRepository.findAll(pageReq);

        return documents;
    }

    public List<DocumentItemDTO> getItem(Integer id){
       List<DocumentItem> items = documentItemRepository.findAll();
       List<DocumentItemDTO> itemDTOS = new ArrayList<>();
       for (DocumentItem i : items){
           if (i.getId() == id){
               itemDTOS.add(new DocumentItemDTO(i));
           }
       }
       return itemDTOS;
    }

    public TrafficDocument save(TrafficDocument trafficDocument){
        return documentRepository.save(trafficDocument);
    }

    @Transactional
    public boolean proknjiziDokument(TrafficDocumentDTO trafficDocumentDTO){
        List<DocumentItemDTO> items = getItem(trafficDocumentDTO.getId());

        if(trafficDocumentDTO.getType().equals("Otpremnica")){
            for (DocumentItemDTO i : items){
                ProductCard card = null;
//                for (ProductCard p : i.getProduct().getProductCards()){
//                    if (p.getWarehouse().getId() ==  trafficDocumentDTO.getWarehouse().getId()){
//                        card = p;
//                    }
//                }

                if(card.getTotalAmount() >= i.getQuantity()){
                    card.setTotalAmount(card.getTotalValue() - i.getQuantity());
                    card.setTrafficExitQuantity((int) (card.getTrafficExitQuantity() + i.getQuantity()));
                    card.setTotalValue(card.getTotalValue() - i.getValue());
                    card.setTrafficExitValue(card.getTrafficExitValue() + i.getValue());
                    cardRepository.save(card);

                    AnalyticsWarehouseCard analytics = new AnalyticsWarehouseCard();
                    analytics.setPrice(new BigDecimal(i.getPrice()));
                    analytics.setQuantity((int) i.getQuantity());
                    analytics.setProductCard(card);
//                    analytics.setDocumentItem(new DocumentItem(i));
                    analytics.setTrafficDirectionEnum(AnalyticsWarehouseCard.TrafficDirectionEnum.I);
                    analytics.setTrafficTypeDirectionEnum(AnalyticsWarehouseCard.TrafficTypeDirectionEnum.OT);
                    analytics.setValue(new BigDecimal(i.getValue()));
                    analytics.setSerialNumber(analytics.getId());
                    trafficDocumentDTO.setStatus("Proknjizen");
                    Date date = new Date();
                    trafficDocumentDTO.setBookingDate(date);
//                    documentRepository.save(new TrafficDocumentDTO(trafficDocumentDTO));
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }
}
