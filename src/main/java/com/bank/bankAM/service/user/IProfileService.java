package com.bank.bankAM.service.user;

import com.bank.bankAM.dto.model.ProfileDTO;

import java.util.List;

public interface IProfileService {

    List<ProfileDTO> profileList();
    ProfileDTO getProfile(long id);
    ProfileDTO addNewProfile(ProfileDTO profileDTO);
    ProfileDTO updateProfile(long id , ProfileDTO profileDTO);
    void deleteProfile(long id);
}
