package pl.itshow.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.itshow.java.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(int id);
}
