package ftn.ac.rs.diplomski.demo.repository;

import ftn.ac.rs.diplomski.demo.entity.ProductCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductCardRepository extends JpaRepository<ProductCard, Integer> {

    Page<ProductCard> findAllById(Integer id, Pageable pageable);

    List<ProductCard> findAllByProductId(Integer id);
}
