package pl.itshow.java.dto.lazyLoadingDataTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MultiSortMeta {

    private String field;

    private int order;

    public MultiSortMeta() {

    }
}
