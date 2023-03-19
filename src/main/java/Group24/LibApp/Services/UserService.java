package Group24.LibApp.Services;

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
