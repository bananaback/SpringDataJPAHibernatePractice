package com.bananaback.SpringDataJPAHibernatePractice.Repositories;

import com.bananaback.SpringDataJPAHibernatePractice.Models.WithdrawTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WithdrawTransactionRepository extends JpaRepository<WithdrawTransaction, Long> {
}
