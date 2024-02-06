package pl.itshow.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.itshow.java.entity.Car;
import pl.itshow.java.entity.Part;

import java.util.List;

public interface PartRepository extends JpaRepository<Part, Long> {

    Part findById(int id);

    List<Part> findAll();
}
