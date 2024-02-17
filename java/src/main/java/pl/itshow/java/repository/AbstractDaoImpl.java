package pl.itshow.java.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AbstractDaoImpl {

//    @PersistenceContext
    protected EntityManager entityManager;

    protected static final Logger logger = LogManager.getLogger();
}
