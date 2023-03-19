package Group24.LibApp.Controllers;

<<<<<<< Updated upstream
import Group24.LibApp.Models.CreditCard;
import Group24.LibApp.Repositories.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit-cards")
public class CreditCardController {
    
    @Autowired
    private CreditCardRepository creditCardRepository;
    
    @PostMapping("/{username}")
    public ResponseEntity<?> createCreditCard(@PathVariable String username, @RequestBody CreditCard creditCard) {
        // determines if user exists
        if (creditCardRepository.existsByUser(username)) {
            creditCard.setUser(creditCardRepository.findByUser(username).getUser());
            creditCardRepository.save(creditCard);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }
    
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Group24.LibApp.Models.CreditCard;
import Group24.LibApp.Services.CreditCardService;

@RestController //annotation makes class serve rest endpoints
@RequestMapping(path = "/credit-card")
public class CreditCardController {

    private final CreditCardService ccService; //utilizes methods from CreditCardService

    @Autowired //annotation serves as dependency injection; ccService is instantiated and injected into constructor
    public CreditCardController(CreditCardService ccService) { //takes in CreditCardService object as param
        this.ccService = ccService;
    }

    @GetMapping //annotation gets data returned by class out of server (rest endpoint)
    public List<CreditCard> getCreditCard() {
        return ccService.getCreditCard(); //retrieves list of credit card info
    }
>>>>>>> Stashed changes
}
