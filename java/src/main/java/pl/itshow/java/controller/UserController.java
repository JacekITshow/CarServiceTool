package pl.itshow.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.itshow.java.dto.UserDto;
import pl.itshow.java.entity.User;
import pl.itshow.java.repository.UserDao;
import pl.itshow.java.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDao userDao;

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

    @PostMapping()
    public void createUser (@RequestBody UserDto userDto) {
        userDao.createUser(userDto);
    }

    @PostMapping("/update/password")
    public void updateUserPassword (@RequestBody int userId, @RequestBody String password) {
        userDao.updateUserPassword(userId, password);
    }

    @PostMapping("/update/email")
    public void updateUserEmail (@RequestBody int userId, @RequestBody String email) {
        userDao.updateUserEmail(userId, email);
    }

    @PatchMapping()
    public void updateUser (UserDto userDto) {
        userDao.updateUser(userDto);
    }

    @DeleteMapping("{userId}")
    public void deleteUser (@PathVariable int userId) {
        userDao.deleteUser(userId);
    }
}
