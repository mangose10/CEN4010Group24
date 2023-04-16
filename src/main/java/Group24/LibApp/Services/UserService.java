package Group24.LibApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Group24.LibApp.Models.User;
import Group24.LibApp.Repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private static UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public static List<User> findByUsername(String username) {
        return userRepository.findByUsername(username); 
    }

}
