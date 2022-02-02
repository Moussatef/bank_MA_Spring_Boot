package com.bank.bankAM.service.user;

import com.bank.bankAM.dto.model.RoleDTO;
import com.bank.bankAM.dto.model.UserMemberShipDTO;

import java.util.List;

public interface IUserMemberShipService {

    List<UserMemberShipDTO> userMemberShipList();
    UserMemberShipDTO getUserMemberShip(long id);
    UserMemberShipDTO addNewUserMemberShip(UserMemberShipDTO userMemberShipDTO);
    UserMemberShipDTO updateUserMemberShip(long id , UserMemberShipDTO userMemberShipDTO);
    void deleteUserMemberShip(long id);
}
