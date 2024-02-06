package pl.itshow.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.itshow.java.dto.CustomerDto;
import pl.itshow.java.entity.Customer;
import pl.itshow.java.repository.ChangePasswordRepository;
import pl.itshow.java.repository.CustomerDao;
import pl.itshow.java.repository.CustomerRepository;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/changepassword")
public class ChangePasswordController {

    @Autowired
    ChangePasswordRepository changePasswordRepository;
    @GetMapping("/{hashcode}")
    Boolean isHashcodeValid (@PathVariable String hashcode) {
        return changePasswordRepository.findByHashcodeAndDateIsAfter(hashcode, new Date());
    }
//    @PostMapping("/resetpassword/{userId}")
//    void getCustomerById (@PathVariable String userId) {
//
//        changePasswordRepository.save(userId);
//    }
}
