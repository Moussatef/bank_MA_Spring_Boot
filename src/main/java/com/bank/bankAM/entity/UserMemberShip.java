package com.bank.bankAM.entity;

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
@Table(name = "usermembershep")
public class UserMemberShip  implements Serializable {

    private static final long serialVersionUID = 17665765754546767L;

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "roleid", referencedColumnName = "id")
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
