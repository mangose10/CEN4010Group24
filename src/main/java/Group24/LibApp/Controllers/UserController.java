package Group24.LibApp.Controllers;

import Group24.LibApp.Models.User;
import Group24.LibApp.Models.CreditCard;
import Group24.LibApp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable("username") String username) {
        User user = userService.findByUsername(username);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{username}")
    public ResponseEntity<Void> updateUser(@PathVariable("username") String username, @RequestBody User user) {
        user.setUsername(username);
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{username}/creditcard")
    public ResponseEntity<Void> addCreditCard(@PathVariable("username") String username, @RequestBody CreditCard creditCard) {
        userService.addCreditCard(username, creditCard);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
