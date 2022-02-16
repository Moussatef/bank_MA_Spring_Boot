package com.bank.bankAM.controller;

import com.bank.bankAM.dto.model.UserDTO;
import com.bank.bankAM.entity.UserMemberShip;
import com.bank.bankAM.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping(path = "/api/user")
@Api(tags = "Users", description = "Users Collection")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @ApiOperation(
            value = "Get List Users ",
            notes = "Show list users from BankMA database"
    )
    @GetMapping(path = "/users")
    public ResponseEntity<List<UserDTO>> getAllUser() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @ApiOperation(
            value = "Add new user ",
            notes = "Add new user to BankMA database"
    )
    @PostMapping

    public UserDTO addNewUser(@RequestBody UserDTO user) {
        return userService.addNewUser(user);
    }

    @ApiOperation(
            value = "Get user by ID",
            notes = "Provide an ID to look a specific user from BankMA database"
    )
    @GetMapping(path = "/get/{id}")

    public UserDTO getUser(@PathVariable("id") long id) {
        return userService.getUser(id);
    }


    @ApiOperation(
            value = "Delete user by ID",
            notes = "Provide an ID to delete a specific user from BankMA database"
    )
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    @ApiOperation(
            value = "Update user ",
            notes = "Update a specific user from BankMA database"
    )

    @PutMapping("/update")
    public UserDTO updtaeUser(@RequestBody UserDTO user){
        return userService.updateUser(user);
    }
}
