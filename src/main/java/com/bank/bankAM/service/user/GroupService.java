package com.bank.bankAM.service.user;

import com.bank.bankAM.entity.Group;
import com.bank.bankAM.entity.UserMemberShip;
import com.bank.bankAM.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> groups(){
        return groupRepository.findAll();
    }

    public Group getGroup(long id){
        return groupRepository.findById(id).orElse(null);
    }

    public void addNewGroup(Group group){
        groupRepository.save(group);
    }

    public void deleteGeoup(Long ID) {
        boolean exists = groupRepository.existsById(ID);
        if (!exists){
            throw new IllegalStateException("Group ID : "+ID+" is not exists");
        }
        groupRepository.deleteById(ID);
    }


}
