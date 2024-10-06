package pl.itshow.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.itshow.java.entity.user.UserPo;

public interface UserRepository extends JpaRepository<UserPo, Long> {

    UserPo findById(long id);

    UserPo findByEmail(String email);
}
