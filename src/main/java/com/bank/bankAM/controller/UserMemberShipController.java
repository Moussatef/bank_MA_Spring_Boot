package com.bank.bankAM.controller;

import com.bank.bankAM.entity.UserMemberShip;
import com.bank.bankAM.service.user.UserMemberShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user-membership")
public class UserMemberShipController {

    private final UserMemberShipService userMemberShipService;

    @Autowired
    public UserMemberShipController(UserMemberShipService userMemberShipService) {
        this.userMemberShipService = userMemberShipService;
    }

    @GetMapping
    public List<UserMemberShip> getAllUserMemberShip(){
        return userMemberShipService.userMemberShipRepositoryList();
    }

    @PostMapping
    public void addNewUserMembership(@PathVariable UserMemberShip userMemberShip){
        userMemberShipService.addUserMemberShip(userMemberShip);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUserMembership(@PathVariable("id") Long id){
        userMemberShipService.deleteUserMember(id);
    }
}
