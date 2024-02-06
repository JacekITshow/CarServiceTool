package pl.itshow.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.itshow.java.entity.Permission;
import pl.itshow.java.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findById(int id);
}
