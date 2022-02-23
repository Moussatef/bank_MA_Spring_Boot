package com.bank.bankAM.controller;

import com.bank.bankAM.dto.model.UserDTO;
import com.bank.bankAM.dto.service.IMapClassWithDto;
import com.bank.bankAM.entity.User;
import com.bank.bankAM.entity.UserMemberShip;
import com.bank.bankAM.repository.UserMemberShipRepository;
import com.bank.bankAM.repository.UserRepository;
import com.bank.bankAM.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RequiredArgsConstructor
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private UserService userService;

    @Mock
    private UserRepository userRepo;

    @Autowired
    IMapClassWithDto<User, UserDTO> userMapping;



    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void getAllUser() {

    }

    @Test
    public void addNewUser() {
        UserDTO userDto = new UserDTO(
                1L,
                null,
                true,
                "gggg",
                "hash",
                "Med",
                "Idbihi",
                "Dev",
                "Java Developer",
                null,
                null,
                LocalDate.now(),
                LocalDate.now()
        );

        User user = userMapping.convertToEntity(userDto, User.class);
        when(userRepo.save(user)).thenReturn(user);
        assertNotNull(userRepo.save(user));
    }

    @Test
    public void getUser() {
        //User user = new User(12L,   false,"Admin","p@ssword","Othman","Moussatef","Dev","Testing",null,null);
        UserDTO userDto = new UserDTO(
                1L,
                null,
                true,
                "gggg",
                "hash",
                "Med",
                "Idbihi",
                "Dev",
                "Java Developer",
                null,
                null,
                LocalDate.now(),
                LocalDate.now()
        );
        User user = userMapping.convertToEntity(userDto, User.class);
        when(userRepo.findById(user.getId())).thenReturn(Optional.of(user));
        assertNotNull(userService.getUser(user.getId()));
    }
}