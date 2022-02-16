package com.bank.bankAM.config;

import com.bank.bankAM.entity.Group;
import com.bank.bankAM.entity.Role;
import com.bank.bankAM.entity.User;
import com.bank.bankAM.entity.UserMemberShip;
import com.bank.bankAM.enums.RoleEnum;
import com.bank.bankAM.repository.GroupRepository;
import com.bank.bankAM.repository.RoleRepository;
import com.bank.bankAM.repository.UserMemberShipRepository;
import com.bank.bankAM.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration @RequiredArgsConstructor
public class UserConfig {

    private final PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner commandLineRunner(RoleRepository roleRepository,UserRepository userRepository,GroupRepository groupRepository,UserMemberShipRepository userMemberShipRepository){

       return  args -> {
           User user = new User(false,"Admin","p@ssword","Othman","Moussatef","Dev","Testing",null,null);
           User user_ = new User(false,"dev","p@ssword","dev","dev","Dev","heroku",user,user);
           user.setPassword(passwordEncoder.encode(user.getPassword()));
           user_.setPassword(passwordEncoder.encode(user_.getPassword()));


           Role superAdminRole = new Role(RoleEnum.ROLE_SUPER_ADMIN.toString(),RoleEnum.ROLE_SUPER_ADMIN.toString(),"This role for super admin",user);
           Role adminRole = new Role(RoleEnum.ROLE_ADMIN.toString(),RoleEnum.ROLE_ADMIN.toString(),"This role for admin",user);
           Role normalUserRole = new Role(RoleEnum.ROLE_NORMAL_USER.toString(),RoleEnum.ROLE_NORMAL_USER.toString(),"This role for normal user",user);

           Group group1 = new Group("BMCE","BMCE","BMCE","Bank BMCE",null);
           Group group2 = new Group("CIH","CIH","CIH","Bank CIH",null);

           UserMemberShip userMemberShip1 = new UserMemberShip(user,superAdminRole,group2,user);
           UserMemberShip userMemberShip2 = new UserMemberShip(user_,adminRole,group1,user);

           userRepository.saveAll(List.of(user,user_));

           groupRepository.saveAll(List.of(group1,group2));

           roleRepository.saveAll(List.of(superAdminRole,adminRole,normalUserRole));

           userMemberShipRepository.saveAll(List.of(userMemberShip1,userMemberShip2));



        };
    }

}
