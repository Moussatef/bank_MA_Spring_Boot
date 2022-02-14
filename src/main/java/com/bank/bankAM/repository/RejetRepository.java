package com.bank.bankAM.repository;

import com.bank.bankAM.entity.Rejet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RejetRepository extends JpaRepository<Rejet,Long> {

}
