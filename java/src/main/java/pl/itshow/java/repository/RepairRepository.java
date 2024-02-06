package pl.itshow.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.itshow.java.entity.Repair;

public interface RepairRepository extends JpaRepository<Repair, Long> {

    Repair findById(int id);
}
