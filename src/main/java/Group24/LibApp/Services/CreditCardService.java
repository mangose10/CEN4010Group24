package Group24.LibApp.Services;

<<<<<<< Updated upstream
public class CreditCardService implements CreditCardService {
    private CreditCardRepository creditCardRepository;
=======
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import Group24.LibApp.Models.CreditCard;

@Service
public class CreditCardService {

    public List<CreditCard> getCreditCard() {
        return List.of(
            new CreditCard(
                "jane doe", 
                "123 456 789", 
                LocalDate.of(26, null, 12), 
                456)
                );
    }
    
>>>>>>> Stashed changes
}
