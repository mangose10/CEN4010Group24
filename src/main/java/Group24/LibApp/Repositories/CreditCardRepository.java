package Group24.LibApp.Repositories;

<<<<<<< Updated upstream
import Group24.LibApp.Models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    boolean existsByUser(String username);
    CreditCard findByUser(String username);
=======
public class CreditCardRepository {
    
>>>>>>> Stashed changes
}
