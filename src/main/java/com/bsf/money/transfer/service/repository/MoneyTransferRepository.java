package com.bsf.money.transfer.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bsf.money.transfer.service.model.MoneyTransfer;

@Repository
public interface MoneyTransferRepository extends JpaRepository<MoneyTransfer, Long> {
}
