package pl.itshow.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.itshow.java.entity.car.PartPo;

import java.util.List;

public interface PartRepository extends JpaRepository<PartPo, Long> {

    PartPo findById(int id);

    List<PartPo> findAll();
}
