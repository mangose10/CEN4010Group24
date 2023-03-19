package Group24.LibApp.Controllers;

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

    @Autowired
    private final CreditCardService creditCardService; //utilizes methods from CreditCardService

    public CreditCardController(CreditCardService creditCardService) { //takes in CreditCardService object as param
        this.creditCardService = creditCardService;
    }

    @GetMapping //annotation gets data returned by class out of server (rest endpoint)
    public List<CreditCard> getCreditCard() {
        return creditCardService.getCreditCard(); //retrieves list of credit card info
    }
}
