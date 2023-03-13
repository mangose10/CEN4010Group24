package Group24.LibApp.Controllers;

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
        // Check if user exists
        if (creditCardRepository.existsByUser_Username(username)) {
            creditCard.setUser(creditCardRepository.findByUser_Username(username).getUser());
            creditCardRepository.save(creditCard);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }
    
}
