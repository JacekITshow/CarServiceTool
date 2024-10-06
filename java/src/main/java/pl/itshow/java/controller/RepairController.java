package pl.itshow.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.itshow.java.entity.Repair;
import pl.itshow.java.repository.RepairRepository;

import java.util.List;

@RestController
@RequestMapping("/api/repair")
public class RepairController {

    @Autowired
    RepairRepository repairRepository;

    @GetMapping("/all")
    List<Repair> getAllRepair() {
        return repairRepository.findAll();
    }

    @GetMapping("/{repairId}")
    public Repair getRepairById (@PathVariable int repairId) {
        return repairRepository.findById(repairId);
    }
}
