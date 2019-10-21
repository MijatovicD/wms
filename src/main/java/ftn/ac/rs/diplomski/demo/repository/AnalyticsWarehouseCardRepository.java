package ftn.ac.rs.diplomski.demo.repository;

import ftn.ac.rs.diplomski.demo.entity.AnalyticsWarehouseCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnalyticsWarehouseCardRepository extends JpaRepository<AnalyticsWarehouseCard, Integer> {

    List<AnalyticsWarehouseCard> findAllByProductCardId(Integer id);
    Page<AnalyticsWarehouseCard> findAllByProductCardId(Integer id, Pageable pageable);
}
