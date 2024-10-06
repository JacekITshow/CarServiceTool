package pl.itshow.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.itshow.java.repository.ChangePasswordRepository;

import java.util.Date;

@RestController
@RequestMapping("/api/changepassword")
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
