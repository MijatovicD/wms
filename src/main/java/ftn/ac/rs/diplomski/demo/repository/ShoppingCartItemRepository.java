package ftn.ac.rs.diplomski.demo.repository;

import ftn.ac.rs.diplomski.demo.entity.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Integer> {

    List<ShoppingCartItem> findAllByUserId(Integer id);
}
