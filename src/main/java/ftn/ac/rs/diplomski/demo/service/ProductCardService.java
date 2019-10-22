package ftn.ac.rs.diplomski.demo.service;

import ftn.ac.rs.diplomski.demo.entity.AnalyticsWarehouseCard;
import ftn.ac.rs.diplomski.demo.entity.Product;
import ftn.ac.rs.diplomski.demo.entity.ProductCard;
import ftn.ac.rs.diplomski.demo.repository.AnalyticsWarehouseCardRepository;
import ftn.ac.rs.diplomski.demo.repository.ProductCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;


@Service
public class ProductCardService{

    @Autowired
    private ProductCardRepository productCardRepository;

    @Autowired
    private AnalyticsWarehouseCardRepository analyticsWarehouseCardRepository;

    public Page<ProductCard> findAllPaged(Integer page, Integer size){
        PageRequest pageReq = PageRequest.of(page, size);
        Page<ProductCard> cards = productCardRepository.findAll(pageReq);

        return cards;
    }

    public List<ProductCard> findAllByProductId(Integer id){
        return productCardRepository.findAllByProductId(id);
    }

    public List<ProductCard> findAllByWarehouseId(Integer id){
        return productCardRepository.findAllByWarehouseId(id);
    }

    public ProductCard findById(Integer id){
        return productCardRepository.getOne(id);
    }

    @Transactional
    public boolean nivelacija(Integer id){
        ProductCard card = productCardRepository.getOne(id);
        List<AnalyticsWarehouseCard> am = analyticsWarehouseCardRepository.findAllByProductCardId(card.getId());
        int totalValue = 0;
        for (AnalyticsWarehouseCard a : am){
            if (a.getTrafficTypeDirectionEnum() == AnalyticsWarehouseCard.TrafficTypeDirectionEnum.NI){
                continue;
            }
            if (a.getTrafficTypeDirectionEnum() == AnalyticsWarehouseCard.TrafficTypeDirectionEnum.PR){
                totalValue += a.getValue().intValue();
            }
            if (a.getTrafficTypeDirectionEnum() == AnalyticsWarehouseCard.TrafficTypeDirectionEnum.OT){
                totalValue -= a.getValue().intValue();
            }
        }

        if (totalValue == 0){
            return false;
        }
        if (totalValue == card.getTotalValue()){
            return false;
        }

        AnalyticsWarehouseCard analyticsWarehouseCard = new AnalyticsWarehouseCard();
        analyticsWarehouseCard.setTrafficTypeDirectionEnum(AnalyticsWarehouseCard.TrafficTypeDirectionEnum.NI);
        analyticsWarehouseCard.setValue(new BigDecimal(card.getTotalAmount() - totalValue));
        analyticsWarehouseCard.setProductCard(card);
        analyticsWarehouseCard.setPrice(new BigDecimal(0));
        analyticsWarehouseCard.setQuantity(0);
        analyticsWarehouseCard.setTrafficDirectionEnum(AnalyticsWarehouseCard.TrafficDirectionEnum.U);
        analyticsWarehouseCard = analyticsWarehouseCardRepository.save(analyticsWarehouseCard);
        analyticsWarehouseCard.setSerialNumber(analyticsWarehouseCard.getId());
        analyticsWarehouseCardRepository.save(analyticsWarehouseCard);
        productCardRepository.save(card);

        return true;
    }
}
