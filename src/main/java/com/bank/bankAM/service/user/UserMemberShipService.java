package com.bank.bankAM.service.user;

import com.bank.bankAM.entity.Profile;
import com.bank.bankAM.entity.User;
import com.bank.bankAM.entity.UserMemberShip;
import com.bank.bankAM.repository.UserMemberShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMemberShipService {

    private final UserMemberShipRepository userMemberShipRepository;

    @Autowired
    public UserMemberShipService(UserMemberShipRepository userMemberShipRepository) {
        this.userMemberShipRepository = userMemberShipRepository;
    }

    public UserMemberShip getUserMemberShip(long id){
        return userMemberShipRepository.findById(id).orElse(null);
    }

    public List<UserMemberShip> userMemberShipRepositoryList(){
        return userMemberShipRepository.findAll();
    }

    public void addUserMemberShip(UserMemberShip userMemberShip){
        userMemberShipRepository.save(userMemberShip);
    }

    public void deleteUserMember(Long id){
        boolean exists = userMemberShipRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("This user member ship  ID : "+id+" is not exists");
        }
        userMemberShipRepository.deleteById(id);
    }
}
