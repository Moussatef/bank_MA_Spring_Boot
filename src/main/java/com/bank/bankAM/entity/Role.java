package com.bank.bankAM.entity;

import com.bank.bankAM.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role implements Serializable {

    private static final long serialVersionUID = 1876875764758L;

    @Id

    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id", nullable = false)
    private long id;

    private String name;

    private String displayName;

    @Column(name = "description",columnDefinition="TEXT")
    private String description;

    @ManyToOne()
    @JoinColumn(name = "createdby")
    private User createdBy;

    @CreationTimestamp
    private LocalDate creationDate;

    @UpdateTimestamp
    private LocalDate lastUpdate;

    public Role(String roleSuperAdmin, String roleSuperAdmin1, String description, User user) {
        this.name = roleSuperAdmin;
        this.displayName=roleSuperAdmin1;
        this.description = description;
        this.createdBy =user;
    }

    //@OneToMany
    //private List<UserMemberShip> userMemberShip;

}
