package Group24.LibApp.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Group24.LibApp.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
}
