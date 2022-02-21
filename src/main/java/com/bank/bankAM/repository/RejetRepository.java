package com.bank.bankAM.repository;

import com.bank.bankAM.entity.Rejet;
import com.bank.bankAM.rejetST.StatistiqueByDate;
import com.bank.bankAM.rejetST.StatistiqueRejetByTakenBy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Repository
public interface RejetRepository extends JpaRepository<Rejet,Long> {

    @Query( value = "select DATE(declaration_date) AS dateRejet , count(*) AS nbRejet from rejet group by DATE(declaration_date)",nativeQuery = true)
    List<StatistiqueByDate> statistiquesRejetByDate();

    @Query(value = "select DATE(declaration_date) AS date ,takenby AS takenBy, count(*) AS nbRejet from rejet group by DATE(declaration_date) , takenby",nativeQuery = true)
    List<StatistiqueRejetByTakenBy> statistiqueByTakenBy();

}
