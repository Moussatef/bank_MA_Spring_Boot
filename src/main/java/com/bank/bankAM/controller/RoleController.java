package com.bank.bankAM.controller;

import com.bank.bankAM.entity.Group;
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
    @GetMapping(path = "/get/{id}")
    public Role getRole(@PathVariable("id") long id){
        return roleService.getRole(id);
    }
    @PostMapping
    public void addNewRole(@RequestBody Role role){
        roleService.addNewRole(role);
    }

    @DeleteMapping (path = "{id}")
    public void deleteGroup(@PathVariable("id") Long groupId){
        roleService.deleteRole(groupId);

    }


}
