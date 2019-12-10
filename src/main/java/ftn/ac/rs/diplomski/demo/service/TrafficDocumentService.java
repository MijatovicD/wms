package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.dto.DocumentItemDTO;
import ftn.ac.rs.diplomski.demo.dto.InterWarehouseDTO;
import ftn.ac.rs.diplomski.demo.dto.ProductCardDTO;
import ftn.ac.rs.diplomski.demo.dto.TrafficDocumentDTO;
import ftn.ac.rs.diplomski.demo.entity.*;
import ftn.ac.rs.diplomski.demo.repository.DocumentRepository;
import ftn.ac.rs.diplomski.demo.repository.InterWarehouseTrafficRepository;
import ftn.ac.rs.diplomski.demo.repository.ProductCardRepository;
import ftn.ac.rs.diplomski.demo.repository.TrafficDocumentItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
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

    @Autowired
    private BussinesYearServise yearServise;

    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private AnalyticsWarehouseCardService analyticsWarehouseCardService;

    @Autowired
    private InterWarehouseTrafficRepository interWarehouseTrafficRepository;


    public TrafficDocument getDocument(Integer id){

        return documentRepository.findById(id).get();
    }

    public Page<TrafficDocument> findAllPaged(Integer page, Integer size){
        PageRequest pageReq = PageRequest.of(page, size);
        Page<TrafficDocument> documents = documentRepository.findAll(pageReq);

        return documents;
    }

    public List<DocumentItemDTO> getItem(Integer id){
        List<DocumentItemDTO> allDTO = documentItemRepository.findAll().stream().map(
                item -> new DocumentItemDTO(item)
        ).collect(Collectors.toList());
        List<DocumentItemDTO> items = new ArrayList<>();
        for (DocumentItemDTO i : allDTO){
            if(i.getDocument().getId() == id){
                items.add(i);
            }
        }
        return items;
    }

    public List<InterWarehouseDTO> getInterWarehouseItems(Integer id){
        List<InterWarehouseDTO> allDTO = interWarehouseTrafficRepository.findAll().stream().map(
                item -> new InterWarehouseDTO(item)
        ).collect(Collectors.toList());
        List<InterWarehouseDTO> items = new ArrayList<>();
        for (InterWarehouseDTO i : allDTO){
            if (i.getTrafficDocumentDTO().getId() == id){
                items.add(i);
            }
        }
        return items;
    }

    public TrafficDocument save(TrafficDocument trafficDocument){
        return documentRepository.save(trafficDocument);
    }

    @Transactional
    public boolean proknjiziDokument(TrafficDocumentDTO trafficDocumentDTO){
        List<DocumentItemDTO> items = getItem(trafficDocumentDTO.getId());

        if(trafficDocumentDTO.getType().equals("Otpremnica")){
            System.out.println("ulaziii?");
            for (DocumentItemDTO i : items){
                ProductCard card = null;
                for (ProductCard p : i.getProduct().getProductCards()){
                    if (p.getWarehouse().getId() ==  trafficDocumentDTO.getWarehouse().getId()){
                        card = p;
                    }
                }


                if(card.getTotalAmount() >= i.getQuantity()){
                    card.setTotalAmount(card.getTotalAmount() - i.getQuantity());
                    card.setTrafficExitQuantity((int) (card.getTrafficExitQuantity() + i.getQuantity()));
                    card.setTotalValue(card.getTotalValue() - i.getValue());
                    card.setTrafficExitValue(card.getTrafficExitValue() + i.getValue());
                    cardRepository.save(card);


                    AnalyticsWarehouseCard analytics = new AnalyticsWarehouseCard();
                    analytics.setPrice(new BigDecimal(i.getPrice()));
                    analytics.setQuantity((int) i.getQuantity());
                    analytics.setProductCard(card);
                    analytics.setDocumentItem(new DocumentItem(i));
                    analytics.setTrafficDirectionEnum(AnalyticsWarehouseCard.TrafficDirectionEnum.I);
                    analytics.setTrafficTypeDirectionEnum(AnalyticsWarehouseCard.TrafficTypeDirectionEnum.OT);
                    analytics.setValue(new BigDecimal(i.getValue()));
                    analytics = analyticsWarehouseCardService.save(analytics);
                    analytics.setSerialNumber(analytics.getId());
                    analyticsWarehouseCardService.save(analytics);
                    trafficDocumentDTO.setStatus("Proknjizen");
                    Date date = new Date();
                    trafficDocumentDTO.setBookingDate(date);
                    documentRepository.save(new TrafficDocument(trafficDocumentDTO));
                    return true;
                }else{
                    return false;
                }
            }

        }if(trafficDocumentDTO.getType().equals("Primka")) {
        //prijem robe

        for (DocumentItemDTO i : items) {
            ProductCard card = null;
            for (ProductCard p : i.getProduct().getProductCards()) {
                if (p.getWarehouse().getId() == trafficDocumentDTO.getWarehouse().getId()) {
                    card = p;
                }
        }

            if (card == null) {
                card = new ProductCard();
                card.setPrice(BigDecimal.valueOf(i.getPrice()).toBigInteger());
                card.setInitStateOfQuantity(0);
                card.setInitStateOfValue(0);
                card.setTrafficEntryQuantity(0);
                card.setTrafficEntryValue(0);
                card.setTrafficExitQuantity(0);
                card.setTrafficEntryValue(0);
                card.setTotalAmount(0);
                card.setTotalValue(0);
                card.setYear(yearServise.findOne(5));
                card.setProduct(i.getProduct());
                card.setWarehouse(warehouseService.findOne(trafficDocumentDTO.getWarehouse().getId()));

            } else {
                card.setPrice(BigDecimal.valueOf(((card.getTotalValue() + i.getQuantity() * i.getPrice()) / (card.getTotalAmount() + i.getQuantity()))).toBigInteger());
            }

            if (i.getQuantity() > 0) {

                card.setTotalAmount(card.getTotalAmount() + i.getQuantity());
                card.setTotalValue(card.getPrice().intValue() * card.getTotalAmount());
                card.setTrafficEntryQuantity((int) (card.getTrafficEntryQuantity() + i.getQuantity()));
                card.setTrafficEntryValue(card.getTrafficEntryValue() + i.getValue());
                cardRepository.save(card);

                AnalyticsWarehouseCard analytics = new AnalyticsWarehouseCard();
                analytics.setPrice(new BigDecimal(i.getPrice()));
                analytics.setQuantity((int) i.getQuantity());
                analytics.setProductCard(card);
                analytics.setDocumentItem(new DocumentItem(i));
                analytics.setTrafficDirectionEnum(AnalyticsWarehouseCard.TrafficDirectionEnum.U);
                analytics.setTrafficTypeDirectionEnum(AnalyticsWarehouseCard.TrafficTypeDirectionEnum.PR);
                analytics.setValue(new BigDecimal(i.getValue()));
                analytics = analyticsWarehouseCardService.save(analytics);
                analytics.setSerialNumber(analytics.getId());
                analyticsWarehouseCardService.save(analytics);
                trafficDocumentDTO.setStatus("Proknjizen");
                Date date = new Date();
                trafficDocumentDTO.setBookingDate(date);
                documentRepository.save(new TrafficDocument(trafficDocumentDTO));

                return true;
            } else {
                return false;
            }
        }
        }
        if(trafficDocumentDTO.getType().equals("Medjumagacinski")) {
            for (DocumentItemDTO i : items) {
                ProductCard card = null;
                for (ProductCard p : i.getProduct().getProductCards()) {
                    if (p.getWarehouse().getId() == trafficDocumentDTO.getWarehouse().getId()) {
                        card = p;
                    }
                }

                if(i.getQuantity() <= card.getTotalAmount()){
                    card.setTrafficEntryQuantity((int) (card.getTrafficEntryQuantity() - i.getQuantity()));
                    cardRepository.save(card);


                    AnalyticsWarehouseCard analytics = new AnalyticsWarehouseCard();
                    analytics.setPrice(new BigDecimal(i.getPrice()));
                    analytics.setQuantity((int) i.getQuantity());
                    analytics.setProductCard(card);
                    analytics.setDocumentItem(new DocumentItem(i));
                    analytics.setTrafficDirectionEnum(AnalyticsWarehouseCard.TrafficDirectionEnum.U);
                    analytics.setTrafficTypeDirectionEnum(AnalyticsWarehouseCard.TrafficTypeDirectionEnum.MM);
                    analytics.setValue(new BigDecimal(i.getValue()));
                    analytics = analyticsWarehouseCardService.save(analytics);
                    analytics.setSerialNumber(analytics.getId());
                    analyticsWarehouseCardService.save(analytics);
                    trafficDocumentDTO.setStatus("Proknjizen");
                    Date date = new Date();
                    trafficDocumentDTO.setBookingDate(date);
                    documentRepository.save(new TrafficDocument(trafficDocumentDTO));
                    return true;


                }
            }

        }

        return false;
    }

    @Transactional
    public boolean storniraj(TrafficDocumentDTO trafficDocumentDTO){
        List<DocumentItemDTO> itemDTOS = getItem(trafficDocumentDTO.getId());
        AnalyticsWarehouseCard analytics = new AnalyticsWarehouseCard();

        if (trafficDocumentDTO.getType().equals("Otpremnica")){
            for (DocumentItemDTO i : itemDTOS){
                ProductCard card = null;
                for (ProductCard p : i.getProduct().getProductCards()){
                    if (p.getWarehouse().getId() == trafficDocumentDTO.getWarehouse().getId()){
                        card = p;
                    }
                }

                if (card.getTotalAmount() >= i.getQuantity()){
                    card.setTotalAmount(card.getTotalAmount() + i.getQuantity());
                    card.setTrafficExitQuantity((int) (card.getTrafficExitQuantity() - i.getQuantity()));
                    card.setTotalValue(card.getTotalValue() + i.getValue());
                    card.setTrafficExitValue(card.getTrafficExitValue() - i.getValue());
                    cardRepository.save(card);

                    trafficDocumentDTO.setStatus("Storniran");
                    documentRepository.save(new TrafficDocument(trafficDocumentDTO));

                    analytics.setQuantity((int) -i.getQuantity());
                    analytics.setPrice(BigDecimal.valueOf(i.getPrice()));
                    analytics.setValue(BigDecimal.valueOf(i.getValue()).negate());
                    analytics.setProductCard(card);
                    analytics.setTrafficDirectionEnum(AnalyticsWarehouseCard.TrafficDirectionEnum.I);
                    analytics.setDocumentItem(documentItemRepository.getOne(i.getId()));
                    analytics.setTrafficTypeDirectionEnum(AnalyticsWarehouseCard.TrafficTypeDirectionEnum.OT);
                    analytics = analyticsWarehouseCardService.save(analytics);
                    analytics.setSerialNumber(analytics.getId());
                    analyticsWarehouseCardService.save(analytics);

                    return true;
                }else{
                    return false;
                }
            }
        }

        //prijem

        else {
            for(DocumentItemDTO i : itemDTOS){
                ProductCard card = null;
                for (ProductCard p : i.getProduct().getProductCards()){
                    if (p.getWarehouse().getId() == trafficDocumentDTO.getWarehouse().getId()){
                        card = p;
                    }
                }

                if (i.getQuantity() > 0){
                    card.setTotalAmount(card.getTotalAmount() - i.getQuantity());
                    card.setTrafficEntryQuantity((int) (card.getTrafficEntryQuantity() - i.getQuantity()));
                    card.setTotalValue(card.getTotalValue() - i.getValue());
                    card.setTrafficEntryValue(card.getTrafficEntryValue() - i.getValue());
                    if (card.getTotalAmount() == 0){
                        card.setPrice(new BigInteger("0"));
                    } else {
                        card.setPrice(BigDecimal.valueOf(((card.getTotalValue())/(card.getTotalAmount()))).toBigInteger());
                    }
                    cardRepository.save(card);

                    trafficDocumentDTO.setStatus("Storniran");
                    documentRepository.save(new TrafficDocument(trafficDocumentDTO));

                    analytics.setQuantity((int) -i.getQuantity());
                    analytics.setPrice(BigDecimal.valueOf(i.getPrice()));
                    analytics.setValue(BigDecimal.valueOf(i.getValue()).negate());
                    analytics.setProductCard(card);
                    analytics.setTrafficDirectionEnum(AnalyticsWarehouseCard.TrafficDirectionEnum.U);
                    analytics.setDocumentItem(documentItemRepository.getOne(i.getId()));
                    analytics.setTrafficTypeDirectionEnum(AnalyticsWarehouseCard.TrafficTypeDirectionEnum.PR);
                    analytics = analyticsWarehouseCardService.save(analytics);
                    analytics.setSerialNumber(analytics.getId());
                    analyticsWarehouseCardService.save(analytics);

                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
