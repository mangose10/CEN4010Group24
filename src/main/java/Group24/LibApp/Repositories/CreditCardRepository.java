package Group24.LibApp.Repositories;

import Group24.LibApp.Models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    boolean existsByUser(String username);
    CreditCard findByUser(String username);
}
