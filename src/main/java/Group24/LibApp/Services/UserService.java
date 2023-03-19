package Group24.LibApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Group24.LibApp.Models.User;
import Group24.LibApp.Repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<User> getUser() {
        return List.of(
            new User(
            "vr1", 
            "1234", 
            "jane doe", 
            "jdoe@email.com", 
            "451 cherry lane")
        );
    }
}
