/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.entity.DefaultApp;
import com.blinfosoft.feedback.entity.DefaultAccount;
import com.blinfosoft.feedback.entity.DomainEntity;
import com.blinfosoft.feedback.entity.impl.Account;
import com.blinfosoft.feedback.exception.AccountNotFoundException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author js
 */
public interface AccountServiceImpl extends DomainEntity<Long>, Serializable {

    Account getAccount(long adminId) throws AccountNotFoundException;

    Account getAccountByName(String userName) throws AccountNotFoundException;

    List<Account> getAccounts();

    Account createAccount(Account user);

    void deleteAccount(long adminId) throws AccountNotFoundException;

    Account updateAccount(Account user) throws AccountNotFoundException;

    boolean accountAlreadyExist(String accountName);
}
