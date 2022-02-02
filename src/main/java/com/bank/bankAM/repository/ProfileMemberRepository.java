package com.bank.bankAM.repository;

import com.bank.bankAM.entity.ProfileMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileMemberRepository extends JpaRepository<ProfileMember,Long> {

}
