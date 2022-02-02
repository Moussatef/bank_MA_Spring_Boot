package com.bank.bankAM.service.user;

import com.bank.bankAM.dto.model.UserDTO;
import com.bank.bankAM.entity.User;

import java.util.List;

public interface IUserService {
    List<UserDTO> getAllUsers();
    UserDTO getUser(long id);
    void addNewUser(User user);
    void deleteUser(Long userId);
    UserDTO updateUser(long id , UserDTO userDTO);
}
