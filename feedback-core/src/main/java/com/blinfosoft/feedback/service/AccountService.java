/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.entity.DefaultAccount;
import com.blinfosoft.feedback.exception.AccountNotFoundException;
import java.util.List;
import com.blinfosoft.feedback.dao.DaoFactory;
import com.blinfosoft.feedback.entity.impl.Account;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author js
 */
public class AccountService implements AccountServiceImpl {

    private final DaoFactory daoFactory;

    protected DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public AccountService(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<Account> getAccounts() {
        return getDaoFactory().getAccountDao().findAll();
    }

    @Override
    public Account createAccount(Account account) {
        try {
            getDaoFactory().getAccountDao().executeInTransaction((em) -> em.persist(account));
        } catch (Exception e) {
            System.out.println(e);
        }
        return account;
    }

    @Override
    public void deleteAccount(long accountId) throws AccountNotFoundException {
        Account account = getDaoFactory().getAccountDao().findByPrimaryKey(accountId).orElseThrow(() -> {
            return new AccountNotFoundException(accountId);
        });
        getDaoFactory().getAccountDao().destroy(account);
    }

    @Override
    public Account updateAccount(Account accountIndata) throws AccountNotFoundException {
        Account account = new DefaultAccount();
        if (account.getAccountName() != null) {
            account.setAccountName(accountIndata.getAccountName());
        }
        getDaoFactory().getAccountDao().executeInTransaction((em) -> em.merge(account));
        return account;
    }

    @Override
    public Account getAccount(long id) throws AccountNotFoundException {
        return getDaoFactory().getAccountDao().findByPrimaryKey(id).orElseThrow(() -> {
            return new AccountNotFoundException(id);
        });
    }

    @Override
    public Account getAccountByName(String name) throws AccountNotFoundException {
        return getDaoFactory().getAccountDao().findByAccountName(name).orElseThrow(() -> {
            return new AccountNotFoundException(name);
        });
    }

    @Override
    public Long getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean accountAlreadyExist(String name) {
        return getDaoFactory().getAccountDao().isAccountExist(name).isPresent();
    }

    @Override
    public boolean verfyAccount(String license){       
       return  getDaoFactory().getAccountDao().verifyAccount(license).isPresent();
    }

}
