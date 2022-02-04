package com.bank.bankAM.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "usercontactinfo")
public class UserContactInfo implements Serializable {

    private static final Long serialVersionUID = 314325436547L;

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id", nullable = false)
    private long id;

    @JsonIgnore
    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "userid",referencedColumnName  ="id",nullable = false,unique = true)
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
