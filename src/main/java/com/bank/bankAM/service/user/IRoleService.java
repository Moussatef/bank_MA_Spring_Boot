package com.bank.bankAM.service.user;

import com.bank.bankAM.dto.model.RoleDTO;

import java.util.List;

public interface IRoleService {

    List<RoleDTO> roleList();
    RoleDTO getRole(long id);
    RoleDTO addNewRole(RoleDTO roleDTO);
    RoleDTO updateRole(long id , RoleDTO roleDTO);
    void deleteRole(long id);
}
