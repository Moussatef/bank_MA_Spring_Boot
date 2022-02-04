package com.bank.bankAM.controller;

import com.bank.bankAM.dto.model.UserDTO;
import com.bank.bankAM.entity.Group;
import com.bank.bankAM.entity.User;
import com.bank.bankAM.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<UserDTO>> getAllUser(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping
    public UserDTO addNewUser(@RequestBody UserDTO user){
       return userService.addNewUser(user);
    }

    @GetMapping(path = "/get/{id}")
    public UserDTO getUser(@PathVariable("id") long id){
        return userService.getUser(id);
    }


    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

}
