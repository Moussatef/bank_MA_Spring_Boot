package com.bank.bankAM.controller;

import com.bank.bankAM.dto.model.UserContactInfoDTO;
import com.bank.bankAM.service.user.UserContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/user-contact-info")
public class UserContactInfoController {

    private final UserContactInfoService userContactInfoService;

    @Autowired
    public UserContactInfoController(UserContactInfoService userContactInfoService) {
        this.userContactInfoService = userContactInfoService;
    }
    @PostMapping
    public UserContactInfoDTO addNewContact(@RequestBody UserContactInfoDTO userContactInfoDTO){
        return userContactInfoService.addNewUserContactInfo(userContactInfoDTO);
    }

    @GetMapping
    public List<UserContactInfoDTO> getAllContactInfo(){
        return userContactInfoService.getAllUserContactInfo();
    }
}
