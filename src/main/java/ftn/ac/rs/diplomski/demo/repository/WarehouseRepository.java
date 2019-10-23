package ftn.ac.rs.diplomski.demo.repository;

import ftn.ac.rs.diplomski.demo.entity.Warehouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

    Page<Warehouse> findByNameContains(String name, Pageable pageable);
}
