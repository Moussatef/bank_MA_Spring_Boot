package com.bank.bankAM.dto.model;

import com.bank.bankAM.entity.User;
import com.bank.bankAM.entity.UserContactInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

    private UserContactInfo userContactInfo;
    private boolean enabled;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String title;
    private String jobTitle;
    private User managerUserId;
    private User createdBy;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
}
