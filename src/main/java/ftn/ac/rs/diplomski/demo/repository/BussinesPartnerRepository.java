package ftn.ac.rs.diplomski.demo.repository;

import ftn.ac.rs.diplomski.demo.entity.BussinessPartner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BussinesPartnerRepository extends JpaRepository<BussinessPartner, Integer> {

    Page<BussinessPartner> findBussinessPartnerByName(String name, Pageable pageable);
}
