package com.bank.bankAM.repository;

import com.bank.bankAM.entity.UserMemberShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMemberShipRepository extends JpaRepository<UserMemberShip,Long> {

}
