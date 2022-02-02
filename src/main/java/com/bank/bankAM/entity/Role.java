package com.bank.bankAM.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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

    //@OneToMany
    //private List<UserMemberShip> userMemberShip;



    public Role(String name, String displayName, String description, User createdBy, LocalDate creationDate, LocalDate lastUpdate) {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
    }
}
