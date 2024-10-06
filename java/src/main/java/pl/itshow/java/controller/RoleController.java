package pl.itshow.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.itshow.java.entity.user.RolePo;
import pl.itshow.java.repository.RoleRepository;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/{roleId}")
    RolePo getRoleById (@PathVariable int roleId) {
        return roleRepository.findById(roleId);
    }

    @GetMapping("/all")
    List<RolePo> getAllRoles() {
        return roleRepository.findAll();
    }
}
