package com.bank.bankAM.service.user;

import com.bank.bankAM.dto.model.GroupDTO;
import com.bank.bankAM.dto.service.IMapClassWithDto;
import com.bank.bankAM.entity.Group;
import com.bank.bankAM.entity.UserMemberShip;
import com.bank.bankAM.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements IGroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Autowired
    IMapClassWithDto<Group,GroupDTO> groupMapper;
    public List<Group> groups(){
        return groupRepository.findAll();
    }

    @Override
    public List<GroupDTO> groupList() {
        List<Group> groupList = groupRepository.findAll();
        return groupMapper.convertListToListDto(groupList,GroupDTO.class);
    }

    @Override
    public void add(GroupDTO groupDTO) {
        Group group = groupMapper.convertToEntity(groupDTO,Group.class);
        groupRepository.save(group);
    }

    @Override
    public void delete(long id) {
        boolean exists = groupRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Group ID : "+id+" is not exists");
        }
        groupRepository.deleteById(id);
    }

    @Override
    public GroupDTO getGroup(long id){
        Group group =  groupRepository.findById(id).orElse(null);
        return groupMapper.convertToDto(group,GroupDTO.class);
    }





}
