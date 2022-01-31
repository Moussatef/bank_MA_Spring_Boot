package com.bank.bankAM.controller;

import com.bank.bankAM.entity.Role;
import com.bank.bankAM.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/role")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getRoles(){
        return roleService.roleList();
    }
    @PostMapping
    public void addNewRole(@RequestBody Role role){
        roleService.addNewRole(role);
    }


}
