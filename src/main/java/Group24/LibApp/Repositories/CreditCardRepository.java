package Group24.LibApp.Repositories;

import Group24.LibApp.Models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CreditCardRepository {
    public void createCreditCard(CreditCard card, String username);
}
