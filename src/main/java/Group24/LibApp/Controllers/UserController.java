package Group24.LibApp.Controllers;

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

    @Autowired
    private final UserService userService; //utilizes methods from UserService

    public UserController(UserService userService) { //takes in UserService object as param
        this.userService = userService;
    }

    @GetMapping //annotation gets data returned by class out of server (rest endpoint)
    public List<User> getUser() {
        return userService.getUser(); //retrieves list of user info
    }
}
