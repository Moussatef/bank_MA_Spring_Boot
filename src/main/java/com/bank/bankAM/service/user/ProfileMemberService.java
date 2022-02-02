package com.bank.bankAM.service.user;

import com.bank.bankAM.repository.ProfileMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileMemberService {
    private final ProfileMemberRepository profileMemberRepository;

    @Autowired
    public ProfileMemberService(ProfileMemberRepository profileMemberRepository) {
        this.profileMemberRepository = profileMemberRepository;
    }


}
