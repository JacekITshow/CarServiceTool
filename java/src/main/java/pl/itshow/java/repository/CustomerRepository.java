package pl.itshow.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.itshow.java.entity.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findById(int id);

    List<Customer> findAll();
}
