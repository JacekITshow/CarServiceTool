package pl.itshow.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.itshow.java.entity.Car;
import pl.itshow.java.entity.Service;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    Service findById(int id);

    List<Service> findAll();
}
