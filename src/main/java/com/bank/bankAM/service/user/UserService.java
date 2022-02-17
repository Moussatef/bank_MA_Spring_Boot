package com.bank.bankAM.service.user;

import com.bank.bankAM.dto.model.UserDTO;
import com.bank.bankAM.dto.service.IMapClassWithDto;
import com.bank.bankAM.entity.User;
import com.bank.bankAM.entity.UserMemberShip;
import com.bank.bankAM.repository.UserMemberShipRepository;
import com.bank.bankAM.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor @Slf4j
public class UserService implements IUserService , UserDetailsService {

    private final UserRepository userRepository;
    private final UserMemberShipRepository userMemberShipRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    IMapClassWithDto<User, UserDTO> userMapping;

    @Override
    public List<UserDTO> getAllUsers(){
        List<User> userList = userRepository.findAll();
        return userMapping.convertListToListDto(userList,UserDTO.class);
    }

    @Override
    public UserDTO getUser(long id){
        User user = userRepository.findById(id).orElse(null);
        return userMapping.convertToDto(user,UserDTO.class);
    }

    @Override
    public UserDTO addNewUser(UserDTO userDTO) {

        User user = userMapping.convertToEntity(userDTO,User.class);
        Optional<User> userOptional =  userRepository.findUserName(user.getUserName());


        if (userOptional.isPresent()){
            throw new IllegalStateException("Username is already taken");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User newUser = userRepository.save(user);
        UserDTO newUser_dto = userMapping.convertToDto(newUser,UserDTO.class);

        Long idUser = newUser_dto.getCreatedBy().getId() ;
        if (idUser.toString().equals("null"))
            return newUser_dto;


        User createdBy = userRepository.findById(idUser).orElse(null);
        User userManager = userRepository.findById(newUser_dto.getManagerUserId().getId()).orElse(null);
        newUser_dto.setCreatedBy(createdBy);
        newUser_dto.setManagerUserId(userManager);

        return newUser_dto;

    }
    @Override
    public void deleteUser(Long userId) {
       boolean exists = userRepository.existsById(userId);
       if (!exists){
           throw new IllegalStateException("User ID : "+userId+" is not exists");
       }
       userRepository.deleteById(userId);
    }

    @Override
    public UserDTO updateUser( UserDTO user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        if(existingUser !=null) {

            User getManageruserid = userMapping.convertToEntity(this.getUser(user.getManagerUserId().getId()),User.class);
            User getCreatedBy = userMapping.convertToEntity(this.getUser(user.getCreatedBy().getId()),User.class);

            existingUser.setEnabled(user.isEnabled());
            existingUser.setUserName(user.getUserName());
            existingUser.setPassword(user.getPassword());
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setTitle(user.getTitle());
            existingUser.setJobTitle(user.getJobTitle());
            existingUser.setManagerUserId(getManageruserid);
            existingUser.setCreatedBy(getCreatedBy);
            log.info("Update user {}",existingUser.getUserName());
        }
        User userUpdated = userRepository.save(existingUser);

        return userMapping.convertToDto(userUpdated,UserDTO.class);
    }

    @Override
    public User getUserByUsername(String username) {
         Optional<User> userOptional =  userRepository.findUserName(username);
        return userOptional.orElse(null);
    }

    @Override
    public void updatePassword(String oldPassword, String newPassword,String confirmPassword, Long id) {
        if (newPassword.equals(confirmPassword)){
            User user = userMapping.convertToEntity(this.getUser(id),User.class) ;
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(newPassword);

            if(encoder.matches(oldPassword, user.getPassword())){
                user.setPassword(hashedPassword);

            }else
                log.warn("old password is not correct");

        }else{
            log.warn("password is not the same !!");
        }



    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        if (userRepository.findUserName(username).isPresent()){
            User user = userRepository.findUserName(username).get();
            List<UserMemberShip> userMemberShip = userMemberShipRepository.findUserMemberShipByUserId(user);
            userMemberShip.forEach(role ->{
                authorities.add(new SimpleGrantedAuthority(role.getRoleId().getName()));
            });

            return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),authorities);
        }else throw  new UsernameNotFoundException("This UserName "+username+" Not found ");


    }


}
