package pl.itshow.java.repository;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import pl.itshow.java.dto.CustomerDto;
import pl.itshow.java.entity.customer.CustomerPo;

import java.util.List;

@Repository
public class CustomerDaoImpl extends AbstractDaoImpl implements CustomerDao {

    public List<CustomerDto> findCustomersByGender(String gender) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomerDto> cq = cb.createQuery(CustomerDto.class);

        Root<CustomerPo> customerRoot = cq.from(CustomerPo.class);
        Predicate predicate = cb.equal(customerRoot.get("gender"), gender);
        cq.where(predicate);
        cq.select(cb.construct(CustomerDto.class,
                customerRoot.get("id"),
                customerRoot.get("firstName"),
                customerRoot.get("lastName"),
                customerRoot.get("gender"),
                customerRoot.get("email"),
                customerRoot.get("phoneNumber"),
                customerRoot.get("birthdate"),
                customerRoot.get("description")
        ));

        TypedQuery<CustomerDto> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

}
