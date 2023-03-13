package Group24.LibApp.Controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCardController {
    private CreditCardService creditCardService;

    // constructor
    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    // credit card API
    @PostMapping("/user/{username}/credit-card")
    public void createCreditCard(@PathVariable("username") String username, @RequestBody CreditCard creditCard) {
        creditCardService.createCreditCard(username, creditCard);
    }

}
