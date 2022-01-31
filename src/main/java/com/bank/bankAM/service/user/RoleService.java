package com.bank.bankAM.service.user;

import com.bank.bankAM.entity.Role;
import com.bank.bankAM.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;


    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> roleList(){
        return roleRepository.findAll();
    }

    void addNewRole(Role role){
        roleRepository.save(role);
    }

    public void deleteUser(Long roleID) {
        boolean exists = roleRepository.existsById(roleID);
        if (!exists){
            throw new IllegalStateException("Role ID : "+roleID+" is not exists");
        }
        roleRepository.deleteById(roleID);
    }

}
