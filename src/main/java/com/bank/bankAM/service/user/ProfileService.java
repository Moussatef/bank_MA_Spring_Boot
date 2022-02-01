package com.bank.bankAM.service.user;

import com.bank.bankAM.entity.Profile;
import com.bank.bankAM.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> profileList(){
        return profileRepository.findAll();
    }

    public Profile getProfile(long id){
        return profileRepository.findById(id).orElse(null);
    }

    public void addNewProfile(Profile profile){
        profileRepository.save(profile);
    }


    public void deleteProfile(long id){
        boolean exists = profileRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Profile ID : "+id+" is not exists");
        }
        profileRepository.deleteById(id);
    }
}
