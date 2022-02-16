package com.bank.bankAM.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name ="users" )
public class User implements Serializable {

    private static final long serialVersionUID = 176565872872682782L;

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id", nullable = false)
    private long id;

    @JsonIgnore
    @OneToOne(targetEntity = UserContactInfo.class, mappedBy = "userId",cascade = CascadeType.ALL)
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

    @ManyToOne()
    @JoinColumn(name = "manageruserid")
    private User managerUserId;

    @ManyToOne()
    @JoinColumn(name = "createdby")
    private User createdBy;

    @CreationTimestamp
    @Column(name = "creationdate")
    private LocalDate creationDate;

    @UpdateTimestamp
    @Column(name = "lastupdate")
    private LocalDate lastUpDate;

    @JsonIgnore
    @OneToMany(targetEntity = Rejet.class, mappedBy = "TakenBy", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Rejet> rejets;


    public User(boolean enabled, String userName, String password, String firstName, String lastName, String title, String jobTitle, User managerUserId, User createdBy) {
        this.enabled = enabled;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.jobTitle = jobTitle;
        this.managerUserId = managerUserId;
        this.createdBy = createdBy;
    }
}
