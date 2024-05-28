package pl.itshow.java.dto.lazyLoadingDataTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataTableStateEvent {

    private int first;
    private int rows;
    private Integer page;
    private Integer totalPages;
    private String sortField;
    private Integer sortOrder;
    private List<MultiSortMeta> multiSortMeta;
    private Map<String, MultiFilterMeta> filters;

    private String plantId;
    private Integer modelYear;
    private Integer manufacturerId;
    private Integer homologationTypeId;

}
