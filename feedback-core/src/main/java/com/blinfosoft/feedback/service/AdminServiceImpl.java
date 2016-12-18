/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.entity.App;
import com.blinfosoft.feedback.entity.Admin;
import java.util.List;

/**
 *
 * @author js
 */
public interface AdminServiceImpl {

    Admin getUser(long adminId);

    Admin getUserByUserName(String userName);

    List<Admin> getUsers();

    Admin createUser(Admin user);

    Admin createUserAndApp(Admin user, App app);

    void deleteUser(long adminId);

    Admin updateUser(Admin user);
}
