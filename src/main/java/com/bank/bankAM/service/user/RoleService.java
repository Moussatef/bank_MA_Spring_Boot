package com.bank.bankAM.service.user;

import com.bank.bankAM.dto.model.RoleDTO;
import com.bank.bankAM.dto.model.UserDTO;
import com.bank.bankAM.dto.service.IMapClassWithDto;
import com.bank.bankAM.entity.Role;
import com.bank.bankAM.entity.User;
import com.bank.bankAM.repository.RoleRepository;
import com.bank.bankAM.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;


    @Autowired
    public RoleService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }


    @Autowired
    IMapClassWithDto<Role, RoleDTO> roleMapper;

    @Override
    public List<RoleDTO> roleList(){

        List<Role> role = roleRepository.findAll();

        return roleMapper.convertListToListDto(role,RoleDTO.class);
    }


    @Override
    public RoleDTO getRole(long id){
        Role role = roleRepository.findById(id).orElse(null);
        return roleMapper.convertToDto(role,RoleDTO.class);
    }

    @Override
    public RoleDTO addNewRole(RoleDTO roleDTO) {
        Role role = roleMapper.convertToEntity(roleDTO,Role.class);
        Role newRole = this.roleRepository.save(role);
        RoleDTO newRoleDto = roleMapper.convertToDto(newRole,RoleDTO.class);
        User getCreatedBy = this.userRepository.findById(newRoleDto.getCreatedBy().getId()).orElse(null);
        newRoleDto.setCreatedBy(getCreatedBy);

        return newRoleDto;


    }

    @Override
    public RoleDTO updateRole(long id, RoleDTO roleDTO) {
        return null;
    }

    @Override
    public void deleteRole(long id) {

    }

    public void deleteRole(Long roleID) {
        boolean exists = roleRepository.existsById(roleID);
        if (!exists){
            throw new IllegalStateException("Role ID : "+roleID+" is not exists");
        }
        roleRepository.deleteById(roleID);
    }

}
