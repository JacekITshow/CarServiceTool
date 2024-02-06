package pl.itshow.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.itshow.java.entity.Car;
import pl.itshow.java.entity.Part;
import pl.itshow.java.repository.CarRepository;
import pl.itshow.java.repository.PartRepository;

import java.util.List;

@RestController
@RequestMapping("/part")
public class PartController {

    @Autowired
    PartRepository partRepository;

    @GetMapping("/{partId}")
    Part getPartById (@PathVariable int partId) {
        return partRepository.findById(partId);
    }

    @GetMapping("/all")
    public List<Part> getAllParts () {
        return partRepository.findAll();
    }
}
