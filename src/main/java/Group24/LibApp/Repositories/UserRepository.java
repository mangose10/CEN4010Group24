package Group24.LibApp.Repositories;

<<<<<<< Updated upstream
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Group24.LibApp.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByUsername(String username);
}
=======
public class UserRepository {
    
}
>>>>>>> Stashed changes
