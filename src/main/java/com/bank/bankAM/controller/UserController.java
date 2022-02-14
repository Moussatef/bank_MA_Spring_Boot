package com.bank.bankAM.controller;

import com.bank.bankAM.dto.model.UserDTO;
import com.bank.bankAM.entity.UserMemberShip;
import com.bank.bankAM.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping

    public ResponseEntity<List<UserDTO>> getAllUser() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping

    public UserDTO addNewUser(@RequestBody UserDTO user) {
        return userService.addNewUser(user);
    }

    @GetMapping(path = "/get/{id}")

    public UserDTO getUser(@PathVariable("id") long id) {
        return userService.getUser(id);
    }


    @DeleteMapping(path = "{userId}")

    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping("/updateUser")

    public UserDTO updtaeUser(@RequestBody UserDTO user){
        return userService.updateUser(user);

    }











    @PostMapping(path = "/test")
    public List<UserMemberShip> getList(@RequestBody UserDTO user) {
        return userService.testList(user.getUserName());
    }

    @GetMapping(path = "/test/{username}")
    public List<UserMemberShip> getListt(@PathVariable("username") String username) {
        return userService.testList(username);
    }

}
