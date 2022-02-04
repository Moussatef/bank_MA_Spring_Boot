package com.bank.bankAM.repository;

import com.bank.bankAM.dto.model.UserDTO;
import com.bank.bankAM.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT user FROM User user WHERE user.userName = ?1")
    Optional<User> findUserName(String username);

    @Query("SELECT user FROM User user WHERE user.userName = ?1")
    UserDTO authByEmailPassword(String email,String password);

}
