package Group24.LibApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CreditCardRepository {
    public void createCreditCard(CreditCard card, String username);
}
