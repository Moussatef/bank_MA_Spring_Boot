package com.bank.bankAM.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePassword {
    private Long id;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;


}
