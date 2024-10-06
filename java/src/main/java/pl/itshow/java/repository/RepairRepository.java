package pl.itshow.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.itshow.java.entity.car.RepairPo;

public interface RepairRepository extends JpaRepository<RepairPo, Long> {

    RepairPo findById(int id);
}
