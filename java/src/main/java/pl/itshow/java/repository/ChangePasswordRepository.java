package pl.itshow.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.itshow.java.entity.ChangePassword;

import java.util.Date;
import java.util.List;

public interface ChangePasswordRepository extends JpaRepository<ChangePassword, Long> {

    Boolean findByHashcodeAndDateIsAfter(String hashCode, Date date);

    List<ChangePassword> findAll();

}
