package pl.itshow.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.itshow.java.dto.CarDto;
import pl.itshow.java.dto.LazyLoadingDataDto;
import pl.itshow.java.entity.car.CarPo;
import pl.itshow.java.repository.CarDao;
import pl.itshow.java.repository.CarRepository;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarDao carDao;

    @GetMapping("/{carId}")
    CarPo getCarById (@PathVariable int carId) {
        return carRepository.findById(carId);
    }

    @GetMapping("/all")
    public List<CarPo> getAllCars () {
        return carRepository.findAll();
    }

    @GetMapping("/lazy")
    public List<CarDto> getAllCars (@RequestBody LazyLoadingDataDto lazyLoadingDataDto) {
        return carDao.findAllLazy(lazyLoadingDataDto);
    }
}
