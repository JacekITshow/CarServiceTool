package pl.itshow.java.dto.lazyLoadingDataTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ResponseLazyLoadingDataDto<T> {

    private int totalRecords;
    private List<T> rows;

    public ResponseLazyLoadingDataDto() {

    }
}
