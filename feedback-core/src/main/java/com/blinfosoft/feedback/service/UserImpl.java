/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.entity.DefaultIssue;
import com.blinfosoft.feedback.entity.DefaultUser;
import java.util.List;

/**
 *
 * @author js
 */
public interface UserImpl {

    DefaultUser getUser(long userId);

    List<DefaultUser> getUsers();

    DefaultUser createUser(DefaultUser user);

    DefaultUser updateUser(DefaultUser user);

    void deleteUser(long userId);
}
