package Group24.LibApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Group24.LibApp.Models.CreditCard;
import Group24.LibApp.Services.CreditCardService;

@RestController //annotation makes class serve rest endpoints
@RequestMapping("/credit-card")
public class CreditCardController {

    @Autowired
    private final CreditCardService creditCardService; //utilizes methods from CreditCardService

    public CreditCardController(CreditCardService creditCardService) { //takes in CreditCardService object as param
        this.creditCardService = creditCardService;
    }

    //String holderName, String cardNumber, LocalDate expirationDate, int cvv

    @GetMapping("/add-creditcard") //annotation gets data returned by class out of server (rest endpoint)
    public ResponseEntity<Void> createCreditCard(
        @RequestParam(value = "username", defaultValue = "") String username,
        @RequestParam(value = "creditCard") CreditCard creditCard
        ) { //HTTP response / param find and return credit card

        if(username.isEmpty() || creditCard == null){
            return ResponseEntity.badRequest().build(); //username / card details not provided
        }
        creditCardService.addCreditCard(creditCard);
        
        return ResponseEntity.ok().build();
    }
}
