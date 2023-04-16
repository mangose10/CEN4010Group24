package Group24.LibApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Group24.LibApp.Models.User;
import Group24.LibApp.Services.UserService;

@RestController //annotation makes class serve rest endpoints
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService; //utilizes methods from UserService

    public UserController(UserService userService) { //takes in UserService object as param
        this.userService = userService;
    }

    @PostMapping("/create-user") //annotation gets data returned by class out of server (rest endpoint)
    public ResponseEntity<Void> createUser(
        @RequestParam(value = "user") User user) { //HTTP response / param find and return user

        if(user == null){
            return ResponseEntity.badRequest().build(); //user obj not provided
        }
        userService.addUser(user);
        
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find-user/{username}") //annotation gets data returned by class out of server (rest endpoint)
    public ResponseEntity<User> getUser(@RequestParam(value = "username", defaultValue = "") String username) { //HTTP response / param find and return user
        if(username.isEmpty()){
            return ResponseEntity.badRequest().build(); //username not provided
        }
        for(User user : userService.getUsers()) {
            if(user.getUsername().equals(username)) {
                return ResponseEntity.ok(user); //goes through all users to find and return one that matches input
            }
        }
        return ResponseEntity.notFound().build(); //in case no user is found
    }

    @PutMapping("/update-user/{username}")
    public ResponseEntity<User> updateUser(@RequestParam(value = "username", defaultValue = "") String username, @RequestBody User updatedUser) {
        List<User> usersToUpdate = UserService.findByUsername(username);
        if(usersToUpdate == null || usersToUpdate.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User userToUpdate = usersToUpdate.get(0);

        userToUpdate.setUsername(updatedUser.getUsername());
        userToUpdate.setPassword(updatedUser.getPassword());
        userToUpdate.setName(updatedUser.getName());
        userToUpdate.setAddress(updatedUser.getAddress());

        userService.updateUser(userToUpdate); // Use the injected userService bean

        return ResponseEntity.ok(userToUpdate);
    }
}
