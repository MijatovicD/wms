package ftn.ac.rs.diplomski.demo.repository;

import ftn.ac.rs.diplomski.demo.entity.BusinessYear;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BussinesYearRepository extends JpaRepository<BusinessYear, Integer> {

    Page<BusinessYear> findAllById(Integer id, Pageable pageable);
}
