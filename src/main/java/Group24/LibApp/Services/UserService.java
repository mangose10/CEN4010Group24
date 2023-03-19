package Group24.LibApp.Services;

<<<<<<< Updated upstream
import Group24.LibApp.Models.CreditCard;
import Group24.LibApp.Models.User;
import Group24.LibApp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new ResourceNotFoundException("User", "username", username);
        }
        return user;
    }

    public void updateUser(String username, User updatedUser) {
        User user = getUserByUsername(username);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setHomeAddress(updatedUser.getHomeAddress());
        userRepository.save(user);
    }

}
=======
import java.util.List;
import org.springframework.stereotype.Service;
import Group24.LibApp.Models.User;

@Service
public class UserService {
    
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
>>>>>>> Stashed changes
