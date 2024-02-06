package pl.itshow.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.itshow.java.entity.Permission;
import pl.itshow.java.entity.Repair;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Permission findById(int id);
}
