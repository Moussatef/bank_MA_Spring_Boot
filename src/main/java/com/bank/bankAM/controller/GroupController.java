package com.bank.bankAM.controller;

import com.bank.bankAM.entity.Group;
import com.bank.bankAM.service.user.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/group")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<Group> getAllGroups(){
        return groupService.groups();
    }

    @GetMapping(path = "/get/{id}")
    public Group getGroup(@PathVariable("id") long id){
        return groupService.getGroup(id);
    }

    @PostMapping
    public void addNewGroup(@RequestBody Group group){
        groupService.addNewGroup(group);
    }

    @DeleteMapping(path = "{groupId}")
    public void deleteGroup(@PathVariable("groupId") Long groupId){
        groupService.deleteGeoup(groupId);
    }
}
