package Group24.LibApp.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import Group24.LibApp.Models.User;

@EnableJpaRepositories("Group24.LibApp.Repositories")
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
}
