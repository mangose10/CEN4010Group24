package Group24.LibApp.Controllers;

<<<<<<< Updated upstream
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
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Group24.LibApp.Models.User;
import Group24.LibApp.Services.UserService;

@RestController //annotation makes class serve rest endpoints
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService; //utilizes methods from UserService

    @Autowired //annotation serves as dependency injection; userService is instantiated and injected into constructor
    public UserController(UserService userService) { //takes in UserService object as param
        this.userService = userService;
    }

    @GetMapping //annotation gets data returned by class out of server (rest endpoint)
    public List<User> getUser() {
        return userService.getUser(); //retrieves list of user info
>>>>>>> Stashed changes
    }
}
