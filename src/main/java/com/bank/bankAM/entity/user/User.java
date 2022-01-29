package com.bank.bankAM.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name ="users" )
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonIgnore
    @OneToOne(targetEntity = UserContactInfo.class, mappedBy = "userId")
    private UserContactInfo userContactInfo;

    @Column(nullable = false)
    private boolean enabled;

    @Column(name = "username",nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(name = "firstname",nullable = false)
    private String firstName;

    @Column(name = "lastname",nullable = false)
    private String lastName;

    private String title;

    private String jobTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manageruserid")
    private User managerUserId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "createdby")
    private User createdBy;

    @CreationTimestamp
    @Column(name = "creationdate")
    private LocalDate creationDate;

    @UpdateTimestamp
    @Column(name = "lastupdate")
    private LocalDate lastUpDate;

    public User(UserContactInfo userContactInfo, boolean enabled, String userName, String password, String firstName, String lastName, String title, String jobTitle, User managerUserId, User createdBy, LocalDate creationDate, LocalDate lastUpDate) {
        this.userContactInfo = userContactInfo;
        this.enabled = enabled;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.jobTitle = jobTitle;
        this.managerUserId = managerUserId;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpDate = lastUpDate;
    }
}
/*
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private int score;
    private boolean malade;
} */