package com.bank.bankAM.service.user;

import com.bank.bankAM.entity.User;
import com.bank.bankAM.entity.UserMemberShip;
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


    public User getUser(long id){
        return userRepository.findById(id).orElse(null);
    }

    public void addNewUser(User user) {

        Optional<User> userOptional =  userRepository.findUserName(user.getUserName());

        if (userOptional.isPresent()){
            throw new IllegalStateException("Username is already taken");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
       boolean exists = userRepository.existsById(userId);
       if (!exists){
           throw new IllegalStateException("User ID : "+userId+" is not exists");
       }
       userRepository.deleteById(userId);
    }
}
