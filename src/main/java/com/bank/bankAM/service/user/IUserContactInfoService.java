package com.bank.bankAM.service.user;

import com.bank.bankAM.dto.model.UserContactInfoDTO;
import com.bank.bankAM.dto.model.UserDTO;
import com.bank.bankAM.entity.User;

import java.util.List;

public interface IUserContactInfoService {


    List<UserContactInfoDTO> getAllUserContactInfo();
    UserContactInfoDTO getUserContactInfo(long id);
    UserContactInfoDTO addNewUserContactInfo(UserContactInfoDTO user);
    void deleteUserContactInfo(Long userId);
    UserContactInfoDTO updateUserContactInfo(long id , UserContactInfoDTO userContactInfoDTO);
}
