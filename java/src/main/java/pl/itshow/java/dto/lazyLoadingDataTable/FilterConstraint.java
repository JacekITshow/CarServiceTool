package pl.itshow.java.dto.lazyLoadingDataTable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterConstraint {

    private Object value;

    private String matchMode;

    @JsonIgnore
    public String getSqlClause() {
        switch (matchMode) {
            case "equals":
            case "dateIs":
                return "=";
            case "notEquals":
            case "dateIsNot":
                return "!=";
            case "notContains":
                return " not like ";
            case "gt":
            case "dateAfter":
                return ">";
            case "gte":
                return ">=";
            case "lt":
            case "dateBefore":
                return "<";
            case "lte":
                return "<=";
            default:
                return " like ";
        }
    }

    @JsonIgnore
    public Object getSqlValue() {
        final Object value = getValue();
        switch (matchMode) {
            case "contains":
            case "notContains":
                return "%" + value + "%";
            case "startsWith":
                return value + "%";
            case "endsWith":
                return "%" + value;
            case "gt":
            case "gte":
            case "lt":
            case "lte":
                // TODO: BigDecimal not supported yet
                return Integer.parseInt((String) value);
            case "dateAfter":
            case "dateBefore":
            case "dateIs":
            case "dateIsNot":
                return Instant.parse((String) value);
            default:
                return value;
        }
    }
}
