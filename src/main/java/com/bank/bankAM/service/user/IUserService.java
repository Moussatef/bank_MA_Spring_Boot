package com.bank.bankAM.service.user;

import com.bank.bankAM.dto.model.UserDTO;
import com.bank.bankAM.entity.User;

import java.util.List;

public interface IUserService {
    List<UserDTO> getAllUsers();
    UserDTO getUser(long id);
    UserDTO addNewUser(UserDTO user);
    void deleteUser(Long userId);
    UserDTO updateUser( UserDTO userDTO);

    User getUserByUsername(String username);

    void updatePassword(String oldPassword,String newPassword,String confirmPassword,Long id);
}
