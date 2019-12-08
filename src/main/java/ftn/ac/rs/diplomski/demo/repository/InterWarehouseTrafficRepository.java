package ftn.ac.rs.diplomski.demo.repository;

import ftn.ac.rs.diplomski.demo.entity.InterWarehouseTraffic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterWarehouseTrafficRepository extends JpaRepository<InterWarehouseTraffic, Integer> {
}
