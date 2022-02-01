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
public class ProfileDTO {

    private boolean isDefault;
    private String name ;
    private String description;
    private User createdBy;
    private LocalDate creationDate;
    private LocalDate lastUpdateDate;
    private User lastUpdateBy;
}
