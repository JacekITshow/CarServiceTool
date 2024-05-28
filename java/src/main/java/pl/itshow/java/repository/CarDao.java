package pl.itshow.java.repository;

import pl.itshow.java.dto.CarDto;
import pl.itshow.java.dto.LazyLoadingDataDto;

import java.util.List;

public interface CarDao {

    List<CarDto> findAllLazy(final LazyLoadingDataDto lazyLoadingDataDto);
}
