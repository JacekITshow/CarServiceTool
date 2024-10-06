package pl.itshow.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.itshow.java.entity.car.ServicePo;

import java.util.List;

public interface ServiceRepository extends JpaRepository<ServicePo, Long> {

    ServicePo findById(int id);

    List<ServicePo> findAll();
}
