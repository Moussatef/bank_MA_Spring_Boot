package com.bank.bankAM.entity.user;

import com.bank.bankAM.entity.group.Group;
import com.bank.bankAM.entity.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user_member_shep")
public class UserMemberShip  implements Serializable {

    private static final long serialVersionUID = 17665765754546767L;

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleid")
    private Role roleId;

    @ManyToOne
    @JoinColumn(name = "groupid")
    private Group groupId;

    @ManyToOne
    @JoinColumn(name = "assignedby")
    private User assignedBy;

    @CreationTimestamp
    @Column(name = "assigneddate")
    private LocalDate assignedDate;


    public UserMemberShip(User userId, Role roleId, Group groupId, User assignedBy, LocalDate assignedDate) {
        this.userId = userId;
        this.roleId = roleId;
        this.groupId = groupId;
        this.assignedBy = assignedBy;
        this.assignedDate = assignedDate;
    }
}
