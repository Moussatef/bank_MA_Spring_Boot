package com.bank.bankAM.service.user;

import com.bank.bankAM.dto.model.ProfileMemberDTO;

import java.util.List;

interface IProfileMemberService {

    List<ProfileMemberDTO> profileMemberList();
    ProfileMemberDTO getProfileMember(long id);
    ProfileMemberDTO addNewProfileMember(ProfileMemberDTO profileMemberDTO);
    ProfileMemberDTO updateProfileMember(long id , ProfileMemberDTO profileMemberDTO);
    void deleteProfileMember(long id);

}
