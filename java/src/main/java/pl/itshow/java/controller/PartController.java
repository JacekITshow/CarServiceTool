package pl.itshow.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.itshow.java.entity.car.PartPo;
import pl.itshow.java.repository.PartRepository;

import java.util.List;

@RestController
@RequestMapping("/api/part")
public class PartController {

    @Autowired
    PartRepository partRepository;

    @GetMapping("/{partId}")
    PartPo getPartById (@PathVariable int partId) {
        return partRepository.findById(partId);
    }

    @GetMapping("/all")
    public List<PartPo> getAllParts () {
        return partRepository.findAll();
    }
}
