package pl.itshow.java.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.From;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import pl.itshow.java.dto.lazyLoadingDataTable.DataTableStateEvent;
import pl.itshow.java.dto.lazyLoadingDataTable.MultiFilterMeta;
import pl.itshow.java.dto.lazyLoadingDataTable.MultiSortMeta;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AbstractDaoImpl {

    @PersistenceContext
    protected EntityManager entityManager;

    protected static final Logger logger = LogManager.getLogger();

    protected void applySortMap(Map<String, From<?, ?>> filterObjects, List<Order> orderList,
                                final DataTableStateEvent dataTableStateEvent) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        if (dataTableStateEvent.getMultiSortMeta() != null && !dataTableStateEvent.getMultiSortMeta().isEmpty()) {
            for (MultiSortMeta multiSortMeta : dataTableStateEvent.getMultiSortMeta()) {
                addSortOrder(orderList, multiSortMeta.getField(), multiSortMeta.getOrder(), filterObjects);
            }
        } else {
            addSortOrder(orderList, dataTableStateEvent.getSortField(), dataTableStateEvent.getSortOrder(), filterObjects);
        }
    }

    private void addSortOrder(List<Order> orderList, String field, int order, Map<String, From<?, ?>> filterObjects) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        String[] parts = field.split("\\.");
        String sortField = parts.length > 1 ? parts[1] : parts[0];
        String objectName = parts.length > 1 ? parts[0] : "";
        From<?, ?> object;

        if (filterObjects.containsKey(objectName)) {
            object = filterObjects.get(objectName);
        } else {
            return;
        }
        if (order == -1) {
            orderList.add(criteriaBuilder.desc(object.get(sortField)));
        } else if (order == 1) {
            orderList.add(criteriaBuilder.asc(object.get(sortField)));
        }
    }

    protected void applyFilterMap(Map<String, From<?, ?>> filterObjects, List<Predicate> conditions,
                                  final DataTableStateEvent dataTableStateEvent) {

        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        if (dataTableStateEvent.getFilters() != null && !dataTableStateEvent.getFilters().isEmpty()) {
            for (Map.Entry<String, MultiFilterMeta> filter : dataTableStateEvent.getFilters().entrySet()) {
                String[] parts = filter.getKey().split("\\.");
                String key = parts.length > 1 ? parts[1] : parts[0];
                String objectName = parts.length > 1 ? parts[0] : "root";
                Object value = filter.getValue().getValue();
                From<?, ?> object;
                if (filterObjects.containsKey(objectName)) {
                    object = filterObjects.get(objectName);
                } else {
                    continue;
                }
                if (value instanceof String[] stringsValues) {
                    filterValues(conditions, key, stringsValues, object);
                } else if (value instanceof String stringValue && !stringValue.isBlank()) {
                    filterValue(conditions, key, stringValue, object);
                }
            }
        }
    }

    protected void filterValue(List<Predicate> conditions, String key, String value, From<?, ?> object) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        conditions.add(criteriaBuilder.like(object.get(key), value));
    }

    protected void filterValues(List<Predicate> conditions, String key, String[] values, From<?, ?> object) {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        conditions.add(object.get(key).in(values));
    }
}
