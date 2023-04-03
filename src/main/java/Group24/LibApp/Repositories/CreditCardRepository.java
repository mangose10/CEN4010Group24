package Group24.LibApp.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Group24.LibApp.Models.CreditCard;
import Group24.LibApp.Models.User;
@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    //List<CreditCard> findByUsername(User user);
}
