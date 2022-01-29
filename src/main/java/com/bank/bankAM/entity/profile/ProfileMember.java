package com.bank.bankAM.entity.profile;

import com.bank.bankAM.entity.group.Group;
import com.bank.bankAM.entity.role.Role;
import com.bank.bankAM.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "ProfileMember")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProfileMember {
    private static final long serialVersionUID = 1876766545424324L;

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profileid")
    private Profile profileId;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "groupid")
    private Group groupId;

    @ManyToOne
    @JoinColumn(name = "roleid")
    private Role roleId;

    public ProfileMember(Profile profileId, User userId, Group groupId, Role roleId) {
        this.profileId = profileId;
        this.userId = userId;
        this.groupId = groupId;
        this.roleId = roleId;
    }
}
