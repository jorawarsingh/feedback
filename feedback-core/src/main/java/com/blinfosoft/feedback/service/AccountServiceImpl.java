/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.entity.App;
import com.blinfosoft.feedback.entity.Account;
import java.util.List;

/**
 *
 * @author js
 */
public interface AccountServiceImpl {

    Account getAccount(long adminId);

    Account getAccountByName(String userName);

    List<Account> getAccounts();

    Account createAccount(Account user);

    Account createAccountAndApp(Account user, App app);

    void deleteAccount(long adminId);

    Account updateAccount(Account user);
}
