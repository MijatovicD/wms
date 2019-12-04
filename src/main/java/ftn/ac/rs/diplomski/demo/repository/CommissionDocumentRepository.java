package ftn.ac.rs.diplomski.demo.repository;

import ftn.ac.rs.diplomski.demo.entity.InventoryCommissionDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommissionDocumentRepository extends JpaRepository<InventoryCommissionDocument, Integer> {

//    List<InventoryCommissionDocument> findAllByDocument_Id(Integer id);
}
