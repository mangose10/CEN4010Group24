package Group24.LibApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Group24.LibApp.Models.CreditCard;
import Group24.LibApp.Repositories.CreditCardRepository;

@Service
public class CreditCardService {

    @Autowired
    private final CreditCardRepository creditCardRepository;

    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public List<CreditCard> getCreditCards() {
        return creditCardRepository.findAll();
    }

    public void addCreditCard(CreditCard creditCard) {
        creditCardRepository.save(creditCard);
    }

}
