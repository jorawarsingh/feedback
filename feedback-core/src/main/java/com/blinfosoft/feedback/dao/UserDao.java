/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.dao;

import com.blinfosoft.feedback.entity.DefaultUser;
import com.blinfosoft.feedback.entity.impl.User;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author js
 */
public class UserDao extends GenericDao<User, Long>{

    UserDao(EntityManagerFactory emFactory) {
        super(DefaultUser.class, emFactory);
    }
    
}
