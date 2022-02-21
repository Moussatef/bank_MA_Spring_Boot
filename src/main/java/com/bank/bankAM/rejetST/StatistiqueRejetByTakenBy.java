package com.bank.bankAM.rejetST;

import java.time.LocalDate;

public interface StatistiqueRejetByTakenBy {

    Long getTakenBy();
    LocalDate getDate();
    Integer getNbRejet();
}
