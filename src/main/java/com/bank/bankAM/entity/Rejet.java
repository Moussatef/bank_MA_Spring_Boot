package com.bank.bankAM.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "rejet")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rejet  implements Serializable {
    private static final long serialVersionUID = 7160711990803479745L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(
            nullable = false,
            length = 255
    )
    private String flowType;

    @Column(
            nullable = false,
            length = 255
    )
    private String rejectNature;

    @Column(
            nullable = false,
            length = 255
    )
    private String entity;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime declarationDate;

    @Column(
            nullable = false,
            length = 255
    )
    private String agencyCode;

    @Column(
            nullable = false,
            length = 500
    )
    private long userRegistrationNumber;

    @Column(
            nullable = false,
            length = 255
    )
    private String bu;

    @Column(
            nullable = false,
            length = 255
    )
    private String su;

    @Column(
            nullable = false,
            length = 255
    )
    private String regionalDelegation;

    @Column(
            nullable = false,
            length = 255
    )
    private String subDelegationType;

    @Column(
            nullable = false,
            length = 255
    )
    private String subDelegationName;

    @Column(
            nullable = false,
            length = 255
    )
    private String cliFileCode;

    @Column(
            nullable = false,
            length = 255
    )
    private String clientCode;

    @Column(
            nullable = false,
            length = 255
    )
    private String gravity;

    @Column(
            nullable = false,
            length = 255
    )
    private String zoneCode;

    @Column(
            nullable = false
    )
    private Boolean isWrongField;

    @Column(
            nullable = false,
            length = 255
    )
    private String errorCode;

    @Column(
            nullable = false,
            length = 255
    )
    private String errorLabel;

    @Column(
            nullable = false
    )
    private Boolean isRequestTaken;

    @Column(
            nullable = false,
            length = 255
    )
    private String actionDetail;

    @Column(
            nullable = false,
            length = 255
    )
    private String file;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "takenby", nullable = true, referencedColumnName = "id")
    private User TakenBy;
}
