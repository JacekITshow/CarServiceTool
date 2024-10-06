package pl.itshow.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.itshow.java.entity.car.CarPo;

import java.util.List;

public interface CarRepository extends JpaRepository<CarPo, Long> {

    CarPo findById(int id);

    List<CarPo> findAll();

    @Query(value = "select car.* from car where car.vin = ?1",
            nativeQuery = true)
    CarPo findByVin(String brand);

}
