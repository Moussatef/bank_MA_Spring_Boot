package com.bank.bankAM.controller;

import com.bank.bankAM.dto.model.RoleDTO;
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
    public List<RoleDTO> getRoles(){
        return roleService.roleList();
    }
    @GetMapping(path = "/get/{id}")
    public RoleDTO getRole(@PathVariable("id") long id){
        return roleService.getRole(id);
    }
    @PostMapping
    public RoleDTO addNewRole(@RequestBody RoleDTO role){
       return roleService.addNewRole(role);
    }

    @DeleteMapping (path = "{id}")
    public void deleteGroup(@PathVariable("id") Long groupId){
        roleService.deleteRole(groupId);

    }


}
