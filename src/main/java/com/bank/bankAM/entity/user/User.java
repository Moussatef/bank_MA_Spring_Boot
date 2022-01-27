package com.bank.bankAM.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
    private Long id;
    private boolean enabled;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String title;
    private String jobtitle;
    private String manageruserid;
    private String createdby;
    private LocalDate creationdate;
    private LocalDate lastupdate;

    public User(boolean enabled, String username, String password, String firstname, String lastname, String title, String jobtitle, String manageruserid, String createdby, LocalDate creationdate, LocalDate lastupdate) {
        this.enabled = enabled;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.jobtitle = jobtitle;
        this.manageruserid = manageruserid;
        this.createdby = createdby;
        this.creationdate = creationdate;
        this.lastupdate = lastupdate;
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