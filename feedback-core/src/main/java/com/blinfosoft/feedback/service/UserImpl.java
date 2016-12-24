/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.entity.DefaultIssue;
import com.blinfosoft.feedback.entity.DefaultUser;
import com.blinfosoft.feedback.entity.impl.Account;
import com.blinfosoft.feedback.entity.impl.User;
import com.blinfosoft.feedback.exception.AccountNotFoundException;
import com.blinfosoft.feedback.exception.AppNotFoundException;
import com.blinfosoft.feedback.exception.EmailAlreadyExistException;
import com.blinfosoft.feedback.exception.UserAlreadyExistExceptions;
import com.blinfosoft.feedback.exception.UserNotFoundExceptions;
import java.util.List;

/**
 *
 * @author js
 */
public interface UserImpl {

    User getUser(long userId) throws UserNotFoundExceptions;

    List<User> getUsers(long accountId) throws UserNotFoundExceptions;

    User createUser(User user, String license) throws UserAlreadyExistExceptions;

    User updateUser(User user, String license);

    void deleteUser(long userId);
    
    boolean emailExist(String email);
    
}
