package pl.itshow.java.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import pl.itshow.java.DTO.CustomerDto;
import pl.itshow.java.entity.Customer;

import java.util.List;

@Repository
public class CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    // constructor

    public List<CustomerDto> findCustomersByGender(String gender) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomerDto> cq = cb.createQuery(CustomerDto.class);

        Root<Customer> customerRoot = cq.from(Customer.class);
        Predicate authorNamePredicate = cb.equal(customerRoot.get("gender"), gender);
        cq.where(authorNamePredicate);
        cq.select(cb.construct(CustomerDto.class,
                customerRoot.get("id"),
                customerRoot.get("firstName"),
                customerRoot.get("surname"),
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
