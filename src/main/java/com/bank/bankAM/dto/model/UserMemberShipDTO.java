package com.bank.bankAM.dto.model;

import com.bank.bankAM.entity.Group;
import com.bank.bankAM.entity.Role;
import com.bank.bankAM.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserMemberShipDTO {

    private User userId;
    private Role roleId;
    private Group groupId;
    private User assignedBy;
    private LocalDate assignedDate;
}
