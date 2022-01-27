package com.bank.bankAM.controller.user;

import com.bank.bankAM.entity.user.User;
import com.bank.bankAM.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUser(){
        return userService.getUser();
    }

    @PostMapping
    public void addNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }



    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

}
