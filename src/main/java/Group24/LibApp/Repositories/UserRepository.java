package Group24.LibApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Group24.LibApp.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
