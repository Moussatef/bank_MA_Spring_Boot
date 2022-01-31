package com.bank.bankAM.service.user;

import com.bank.bankAM.entity.user.User;
import com.bank.bankAM.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUser(){
        return userRepository.findAll();
    }



    public void deleteUser(Long userId) {
       boolean exists = userRepository.existsById(userId);
       if (!exists){
           throw new IllegalStateException("User ID : "+userId+" is not exists");
       }
       userRepository.deleteById(userId);
    }
}
