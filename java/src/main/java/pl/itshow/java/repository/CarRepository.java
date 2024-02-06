package pl.itshow.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.itshow.java.entity.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    Car findById(int id);

    List<Car> findAll();

    @Query(value = "select car.* from car where car.vin = ?1",
            nativeQuery = true)
    Car findByVin(String brand);

}
