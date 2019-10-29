package ftn.ac.rs.diplomski.demo.repository;

import ftn.ac.rs.diplomski.demo.entity.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductGroupRepository extends JpaRepository<ProductGroup, Integer> {
}
