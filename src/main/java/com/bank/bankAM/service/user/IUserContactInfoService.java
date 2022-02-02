package com.bank.bankAM.service.user;

import com.bank.bankAM.dto.model.UserContactInfoDTO;
import com.bank.bankAM.dto.model.UserDTO;
import com.bank.bankAM.entity.User;

import java.util.List;

public interface IUserContactInfoService {


    List<UserContactInfoDTO> getAllUsers();
    UserContactInfoDTO getUser(long id);
    void addNewUser(UserContactInfoDTO user);
    void deleteUser(Long userId);
    UserContactInfoDTO updateUser(long id , UserContactInfoDTO userDTO);
}
