package com.bank.bankAM.repository;

import com.bank.bankAM.entity.User;
import com.bank.bankAM.entity.UserMemberShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMemberShipRepository extends JpaRepository<UserMemberShip,Long> {


    List<UserMemberShip> findUserMemberShipByUserId(User user);

}
