package Group24.LibApp.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Group24.LibApp.Models.ShoppingCartItem;

@Repository
public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Long> {
    List<ShoppingCartItem> findByUserId(Integer userId);
    List<ShoppingCartItem> findByOrderByIdDesc();
    List<ShoppingCartItem> findByUserIdAndBookId(Integer userId, Integer bookId);
}
