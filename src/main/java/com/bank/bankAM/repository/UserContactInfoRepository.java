package com.bank.bankAM.repository;

import com.bank.bankAM.entity.UserContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserContactInfoRepository extends JpaRepository<UserContactInfo,Long> {
}
