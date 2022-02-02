package com.bank.bankAM.service.user;

import com.bank.bankAM.dto.model.UserMemberShipDTO;
import com.bank.bankAM.dto.service.IMapClassWithDto;
import com.bank.bankAM.entity.User;
import com.bank.bankAM.entity.UserMemberShip;
import com.bank.bankAM.repository.UserMemberShipRepository;
import com.bank.bankAM.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMemberShipService implements IUserMemberShipService {

    private final UserMemberShipRepository userMemberShipRepository;
    private final UserRepository userRepository;

    @Autowired
    IMapClassWithDto<UserMemberShip, UserMemberShipDTO> userMemberMapper;

    @Autowired
    public UserMemberShipService(UserMemberShipRepository userMemberShipRepository, UserRepository userRepository) {
        this.userMemberShipRepository = userMemberShipRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserMemberShipDTO> userMemberShipList() {
        return null;
    }

    @Override
    public UserMemberShipDTO getUserMemberShip(long id){
        UserMemberShip userMemberShip = userMemberShipRepository.findById(id).orElse(null);

        return userMemberMapper.convertToDto(userMemberShip,UserMemberShipDTO.class);
    }

    @Override
    public UserMemberShipDTO addNewUserMemberShip(UserMemberShipDTO userMemberShipDTO) {
        UserMemberShip userMemberShip = userMemberMapper.convertToEntity(userMemberShipDTO,UserMemberShip.class);
        UserMemberShip newUserMember = userMemberShipRepository.save(userMemberShip);
        UserMemberShipDTO newUser_Member_dto = userMemberMapper.convertToDto(newUserMember,UserMemberShipDTO.class);
        User createdBy = userRepository.findById(newUser_Member_dto.getAssignedBy().getId()).orElse(null);
        newUser_Member_dto.setAssignedBy(createdBy);


        return newUser_Member_dto;
    }

    @Override
    public UserMemberShipDTO updateUserMemberShip(long id, UserMemberShipDTO userMemberShipDTO) {
        return null;
    }

    @Override
    public void deleteUserMemberShip(long id) {

    }

    public List<UserMemberShip> userMemberShipRepositoryList(){
        return userMemberShipRepository.findAll();
    }


    public void deleteUserMember(Long id){
        boolean exists = userMemberShipRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("This user member ship  ID : "+id+" is not exists");
        }
        userMemberShipRepository.deleteById(id);
    }
}
