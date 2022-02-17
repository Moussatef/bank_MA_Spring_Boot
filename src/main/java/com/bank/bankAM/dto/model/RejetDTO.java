package com.bank.bankAM.dto.model;

import com.bank.bankAM.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class RejetDTO {
    private long id;
    private String flowType;
    private String rejectNature;
    private String entity;
    private String agencyCode;
    private long userRegistrationNumber;
    private String bu;
    private String su;
    private String regionalDelegation;
    private String subDelegationType;
    private String subDelegationName;
    private String cliFileCode;
    private String clientCode;
    private String gravity;
    private String zoneCode;
    private Boolean isWrongField;
    private String errorCode;
    private String errorLabel;
    private Boolean isRequestTaken;
    private String actionDetail;
    private String file;
    private User TakenBy;
}