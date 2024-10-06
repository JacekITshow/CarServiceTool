package pl.itshow.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.itshow.java.entity.user.PermissionPo;
import pl.itshow.java.repository.PermissionRepository;

import java.util.List;

@RestController
@RequestMapping("/api/permission")
public class PermissionController {

    @Autowired
    PermissionRepository permissionRepository;

    @GetMapping("/{permissionId}")
    PermissionPo getPermissionById (@PathVariable int permissionId) {
        return permissionRepository.findById(permissionId);
    }

    @GetMapping("/all")
    public List<PermissionPo> getAllPermission () {
        return permissionRepository.findAll();
    }
}
