package pl.itshow.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.itshow.java.entity.user.RolePo;

public interface RoleRepository extends JpaRepository<RolePo, Long> {

    RolePo findById(int id);
}
