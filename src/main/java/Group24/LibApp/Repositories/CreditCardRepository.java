package Group24.LibApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Group24.LibApp.Models.CreditCard;
@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

}
