package com.bank.bankAM.service.user;

import com.bank.bankAM.dto.model.UserDTO;
import com.bank.bankAM.dto.service.IMapClassWithDto;
import com.bank.bankAM.entity.User;
import com.bank.bankAM.entity.UserMemberShip;
import com.bank.bankAM.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    IMapClassWithDto<User, UserDTO> userMapping;

    @Override
    public List<UserDTO> getAllUsers(){
        List<User> userList = userRepository.findAll();
        return userMapping.convertListToListDto(userList,UserDTO.class);
    }

    @Override
    public UserDTO getUser(long id){
        User user = userRepository.findById(id).orElse(null);
        return userMapping.convertToDto(user,UserDTO.class);
    }
    @Override
    public UserDTO addNewUser(UserDTO userDTO) {

        User user = userMapping.convertToEntity(userDTO,User.class);
        Optional<User> userOptional =  userRepository.findUserName(user.getUserName());

        if (userOptional.isPresent()){
            throw new IllegalStateException("Username is already taken");
        }

        User newUser = userRepository.save(user);
        UserDTO newUser_dto = userMapping.convertToDto(newUser,UserDTO.class);
        User createdBy = userRepository.findById(newUser_dto.getCreatedBy().getId()).orElse(null);
        User userManager = userRepository.findById(newUser_dto.getManagerUserId().getId()).orElse(null);
        newUser_dto.setCreatedBy(createdBy);
        newUser_dto.setManagerUserId(userManager);
        return newUser_dto;



    }
    @Override
    public void deleteUser(Long userId) {
       boolean exists = userRepository.existsById(userId);
       if (!exists){
           throw new IllegalStateException("User ID : "+userId+" is not exists");
       }
       userRepository.deleteById(userId);
    }

    @Override
    public UserDTO updateUser(long id, UserDTO userDTO) {
        return null;
    }
}
