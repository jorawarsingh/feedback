/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.dao;

import com.blinfosoft.feedback.entity.DefaultAccount;
import com.blinfosoft.feedback.entity.impl.Account;
import com.blinfosoft.feedback.exception.AccountNotFoundException;
import com.blinfosoft.feedback.service.AccountServiceImpl;
import java.util.Optional;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author js
 */
public class AccountDao extends GenericDao<Account, Long> {

    public AccountDao(EntityManagerFactory emFactory) {
        super(DefaultAccount.class, emFactory);
    }

    public Optional<DefaultAccount> findByAccountName(String name) throws AccountNotFoundException {
        final String queryStr = name != null ? name.trim() : null;
        return execute((em) -> {
            Query query = em.createNativeQuery("SELECT * FROM account WHERE name = \'" + queryStr + "\'", DefaultAccount.class);
            DefaultAccount account = (DefaultAccount) query.getSingleResult();
            return account;
        });
    }

    public Optional<DefaultAccount> isAccountExist(String name) {
        final String queryStr = name != null ? name.trim() : null;
        return execute((em) -> {
            Query query = em.createNativeQuery("SELECT * FROM account WHERE name = \'" + queryStr + "\'", DefaultAccount.class);
            DefaultAccount account = (DefaultAccount) query.getSingleResult();
            return account;
        });
    }
}
