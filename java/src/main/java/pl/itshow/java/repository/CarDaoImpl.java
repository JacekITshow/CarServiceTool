package pl.itshow.java.repository;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import pl.itshow.java.dto.CarDto;
import pl.itshow.java.dto.LazyLoadingDataDto;
import pl.itshow.java.entity.customer.CustomerPo;

import java.util.List;

@Repository
public class CarDaoImpl extends AbstractDaoImpl implements CarDao {

    @Override
    public List<CarDto> findAllLazy(final LazyLoadingDataDto lazyLoadingDataDto) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CarDto> cq = cb.createQuery(CarDto.class);

        Root<CustomerPo> customerRoot = cq.from(CustomerPo.class);

        cq.select(cb.construct(CarDto.class,
                customerRoot.get("id"),
                customerRoot.get("firstName"),
                customerRoot.get("lastName"),
                customerRoot.get("gender"),
                customerRoot.get("email"),
                customerRoot.get("phoneNumber"),
                customerRoot.get("birthdate"),
                customerRoot.get("description")
        ));

        TypedQuery<CarDto> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

}
