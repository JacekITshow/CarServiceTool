package pl.itshow.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.itshow.java.entity.Car;
import pl.itshow.java.repository.CarRepository;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @GetMapping("/{carId}")
    Car getCarById (@PathVariable int carId) {
        return carRepository.findById(carId);
    }

    @GetMapping("/all")
    public List<Car> getAllCars () {
        return carRepository.findAll();
    }
}
