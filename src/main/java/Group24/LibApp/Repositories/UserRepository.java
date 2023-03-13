package Group24.LibApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    public void createUser(User user);
    public User findByUsername(String username);
    public void updateByUsername(String username);
}
