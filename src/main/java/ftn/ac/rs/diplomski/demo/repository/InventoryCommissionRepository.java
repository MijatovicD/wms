package ftn.ac.rs.diplomski.demo.repository;

import ftn.ac.rs.diplomski.demo.entity.InventoryCommission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryCommissionRepository extends JpaRepository<InventoryCommission, Integer> {

    List<InventoryCommission> findAllByInventoryDocumentIsNotContaining();
}
