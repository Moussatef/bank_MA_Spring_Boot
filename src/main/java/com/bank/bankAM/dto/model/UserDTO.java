package com.bank.bankAM.dto.model;

import com.bank.bankAM.entity.User;
import com.bank.bankAM.entity.UserContactInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

    private UserContactInfo userContactInfo;
    private boolean enabled;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String title;
    private String jobTitle;
    private User managerUserId;
    private User createdBy;
    private LocalDate creationDate;
    private LocalDate lastUpDate;
}
