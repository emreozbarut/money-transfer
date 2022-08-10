package com.bsf.money.transfer.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bsf.money.transfer.service.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>
{
}
