package com.bank.bankAM.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Profile implements Serializable {

    private static final long serialVersionUID = 176565476472782L;

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(nullable = false)
    private Long id;

    @Column(name = "isdefault", columnDefinition = "boolean default false")
    private boolean isDefault;
    @Column(name = "name", length = 50)
    private String name ;

    @Column( columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "createdby")
    private User createdBy;

    @CreationTimestamp
    @Column(name = "creationdate")
    private LocalDate creationDate;

    @UpdateTimestamp
    @Column(name = "lastupdatedate")
    private LocalDate lastUpdateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lastupdateby")
    private User lastUpdateBy;




    public Profile(boolean isDefault, String name, String description, User createdBy, LocalDate creationDate, LocalDate lastUpdateDate, User lastUpdateBy) {
        this.isDefault = isDefault;
        this.name = name;
        this.description = description;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdateBy = lastUpdateBy;
    }
}

