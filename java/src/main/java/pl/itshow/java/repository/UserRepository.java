package pl.itshow.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.itshow.java.entity.Customer;
import pl.itshow.java.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(int id);
}
