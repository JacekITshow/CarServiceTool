package pl.itshow.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.itshow.java.entity.User;
import pl.itshow.java.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    List<User> getUser() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public User getUserById (@PathVariable int userId) {
        return userRepository.findById(userId);
    }
    @GetMapping("/list/{page}")
    public Page<User> getUsersListForPage (@PathVariable int page) {
        Pageable pageable = Pageable.ofSize(2).withPage(page);
        return userRepository.findAll(pageable);
    }
}
