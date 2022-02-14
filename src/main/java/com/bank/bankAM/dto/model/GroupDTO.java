package com.bank.bankAM.dto.model;

import com.bank.bankAM.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GroupDTO {

    private long id;
    private String name;
    private String parentPath;
    private String displayName;
    private String description;
    private User createdBy;
    private LocalDate creationDate;
    private LocalDate lastUpdate;

}
