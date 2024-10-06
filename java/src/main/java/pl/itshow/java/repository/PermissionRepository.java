package pl.itshow.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.itshow.java.entity.user.PermissionPo;

public interface PermissionRepository extends JpaRepository<PermissionPo, Long> {

    PermissionPo findById(int id);
}
