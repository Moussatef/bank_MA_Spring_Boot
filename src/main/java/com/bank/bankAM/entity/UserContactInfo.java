package com.bank.bankAM.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "usercontactinfo")
public class UserContactInfo {

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
    private long id;

    @JsonIgnore
    @OneToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", referencedColumnName = "id")
    private User userId;

    @Column(
            nullable = false,
            unique = true
    )
    private String email;

    @Column(
            nullable = false
    )
    private String phone;
    @Column(
            nullable = false
    )
    private String mobile;
    @Column(
            nullable = false
    )    private String fax;

    private String building;

    private String room;

    private String address;

    private String zipCode;

    private String city;

    private String state;

    private String country;

    private String webSite;

    private boolean personal;





}
