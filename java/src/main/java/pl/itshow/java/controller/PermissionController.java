package pl.itshow.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.itshow.java.entity.Permission;
import pl.itshow.java.entity.Service;
import pl.itshow.java.repository.PermissionRepository;
import pl.itshow.java.repository.ServiceRepository;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    PermissionRepository permissionRepository;

    @GetMapping("/{permissionId}")
    Permission getPermissionById (@PathVariable int permissionId) {
        return permissionRepository.findById(permissionId);
    }

    @GetMapping("/all")
    public List<Permission> getAllPermission () {
        return permissionRepository.findAll();
    }
}
