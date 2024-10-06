package pl.itshow.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.itshow.java.entity.customer.CustomerPo;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerPo, Long> {

    CustomerPo findById(int id);

    List<CustomerPo> findAll();
}
