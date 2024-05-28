package pl.itshow.java.dto.lazyLoadingDataTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultiFilterMeta {

    private String operator;

    private List<FilterConstraint> constraints = new ArrayList<>();

    private Object value;

    private String matchMode;

}
