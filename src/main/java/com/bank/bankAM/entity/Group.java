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
@Table(name = "groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Group implements Serializable {

    private static final long serialVersionUID = 167657657657L;

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(name = "name", length = 125)
    private String name;

    private String parentPath;

    private String displayName;

    @Column(name = "description",columnDefinition="TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "createdby")
    private User createdBy;

    @CreationTimestamp
    @Column(name = "creationdate")
    private LocalDate creationDate;

    @UpdateTimestamp
    @Column(name = "lastupdate")
    private LocalDate lastUpdate;



    public Group(String name, String parentPath, String displayName, String description, User createdBy, LocalDate creationDate, LocalDate lastUpdate) {
        this.name = name;
        this.parentPath = parentPath;
        this.displayName = displayName;
        this.description = description;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
    }
}
