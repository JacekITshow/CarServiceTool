package pl.itshow.java.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LazyLoadingDataDto<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -5087457987080272447L;

    private Long first;

    private Long pageSize;

}
