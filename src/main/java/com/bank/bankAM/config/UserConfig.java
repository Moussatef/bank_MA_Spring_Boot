package com.bank.bankAM.config;

import com.bank.bankAM.entity.user.User;
import com.bank.bankAM.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;
@Configuration
public class UserConfig {
    //@Bean
    //CommandLineRunner commandLineRunner(UserRepository repository){
      //  return  args -> {
            /*
            User user1 = new User(
                    false,
                    "Moussatef_Othman",
                    "p@ssword",
                    "Moussatef",
                    "Othman",
                    "Dev",
                    "JAVA FULL-STACK Eng",
                    "MN_0001",
                    "YS_0001",
                    LocalDate.of(1990,10,10),
                    LocalDate.of(1990,10,10)
            );
            User user2 = new User(
                    false,
                    "Bissaoui_YSN",
                    "p@ssword",
                    "Bissaoui",
                    "Yassine",
                    "Dev",
                    "JAVA FULL-STACK Eng",
                    "MN_0001",
                    "YS_0001",
                    LocalDate.of(1990,10,10),
                    LocalDate.of(1990,10,10)
            );*/
            //repository.saveAll(List.of(user1,user2));
       // };


    //}
}
