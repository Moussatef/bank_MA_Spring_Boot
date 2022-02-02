package com.bank.bankAM.service.user;

import com.bank.bankAM.dto.model.GroupDTO;
import com.bank.bankAM.entity.Group;

import java.util.List;

public interface IGroupService {

    List<GroupDTO> groupList();
    void add(GroupDTO group);
    void delete(long id );
    GroupDTO getGroup(long id);
}
