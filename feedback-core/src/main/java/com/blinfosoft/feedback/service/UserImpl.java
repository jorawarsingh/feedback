/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.entity.Issue;
import com.blinfosoft.feedback.entity.User;
import java.util.List;

/**
 *
 * @author js
 */
public interface UserImpl {

    User getUser(long userId);

    List<User> getUsers();

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(long userId);
}
