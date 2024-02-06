package pl.itshow.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.itshow.java.entity.Car;
import pl.itshow.java.entity.Service;
import pl.itshow.java.repository.CarRepository;
import pl.itshow.java.repository.ServiceRepository;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    ServiceRepository serviceRepository;

    @GetMapping("/{serviceId}")
    Service getServiceById (@PathVariable int serviceId) {
        return serviceRepository.findById(serviceId);
    }

    @GetMapping("/all")
    public List<Service> getAllServices () {
        return serviceRepository.findAll();
    }
}
