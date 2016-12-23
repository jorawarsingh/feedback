/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.dao.DaoFactory;
import com.blinfosoft.feedback.entity.DefaultAccount;
import com.blinfosoft.feedback.entity.DefaultUser;
import com.blinfosoft.feedback.entity.impl.Account;
import com.blinfosoft.feedback.entity.impl.User;
import com.blinfosoft.feedback.exception.AccountNotFoundException;
import com.blinfosoft.feedback.exception.UserNotFoundExceptions;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author js
 */
public class UserService implements UserImpl {

    public UserService(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    private final DaoFactory daoFactory;

    protected DaoFactory getDaoFactory() {
        return daoFactory;
    }

    @Override
    public User getUser(long userId) throws UserNotFoundExceptions {
        return getDaoFactory().getUserDao().findByPrimaryKey(userId).orElseThrow(() -> {
            return new UserNotFoundExceptions(userId);
        });
    }

    @Override
    public List<User> getUsers(long accountId) throws AccountNotFoundException{
        return getDaoFactory().getUserDao().findByAccountId(accountId).orElseThrow(() -> {
            return new AccountNotFoundException(accountId);
        });
    }

    @Override
    public User createUser(User user, long accountId) {
        AccountService accountService = new AccountService(daoFactory);
        Account account = new DefaultAccount();
        try {
            account = accountService.getAccount(accountId);
        } catch (AccountNotFoundException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        user.setAccount(account);
        getDaoFactory().getUserDao().executeInTransaction((cm) -> cm.persist(user));
        return user;
    }

    @Override
    public void deleteUser(long userId) {
        User user = getUser(userId);
        getDaoFactory().getUserDao().destroy(user);
    }

    @Override
    public User updateUser(User user, long accountId) {
         AccountService accountService = new AccountService(daoFactory);
        Account account = new DefaultAccount();
        try {
            account = accountService.getAccount(accountId);
        } catch (AccountNotFoundException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        user.setAccount(account);
        getDaoFactory().getUserDao().executeInTransaction((cm) -> cm.merge(user));
        return user;
    }
}
