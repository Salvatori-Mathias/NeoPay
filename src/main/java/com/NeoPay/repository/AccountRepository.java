package com.NeoPay.repository;

import com.NeoPay.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    // interface qui point sur la base
    @Query("SELECT a FROM Account a  WHERE a.id= :id")
    Account findAccountByUserId(Integer id );
}