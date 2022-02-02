package com.bank.bankAM.service.user;

import com.bank.bankAM.dto.model.GroupDTO;

import java.util.List;

public interface IGroupService {

    List<GroupDTO> groupList();
    void add(GroupDTO group);
    void delete(long id );
    GroupDTO getGroup(long id);
    GroupDTO updateGroup(long id , GroupDTO groupDTO);
}
