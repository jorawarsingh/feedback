/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.dao;

import com.blinfosoft.feedback.entity.DefaultUser;
import com.blinfosoft.feedback.entity.impl.User;
import com.blinfosoft.feedback.exception.AppNotFoundException;
import com.blinfosoft.feedback.exception.UserNotFoundExceptions;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author js
 */
public class UserDao extends GenericDao<User, Long>{

    UserDao(EntityManagerFactory emFactory) {
        super(DefaultUser.class, emFactory);
    }
    public Optional<List<User>> findByAccountId(long id) throws UserNotFoundExceptions {
        return execute((em) -> {
            Query query = em.createNativeQuery("SELECT * FROM user WHERE Account_Id = \'" + id + "\'", DefaultUser.class);
            List<User> user = query.getResultList();
            return user;
        });
    }
     public Optional<User> findByAccountEmail(String email) throws UserNotFoundExceptions {
        return execute((em) -> {
            Query query = em.createNativeQuery("SELECT * FROM user WHERE email = \'" + email + "\'", DefaultUser.class);
            User user = (DefaultUser) query.getSingleResult();
            return user;
        });
    }
    
}
