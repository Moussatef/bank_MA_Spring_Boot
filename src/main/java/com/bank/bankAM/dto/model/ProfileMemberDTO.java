package com.bank.bankAM.dto.model;

import com.bank.bankAM.entity.Group;
import com.bank.bankAM.entity.Profile;
import com.bank.bankAM.entity.Role;
import com.bank.bankAM.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProfileMemberDTO {

    private long id;
    private Profile profileId;
    private User userId;
    private Group groupId;
    private Role roleId;

}
