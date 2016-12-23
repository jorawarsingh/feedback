/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.dao;

import com.blinfosoft.feedback.entity.DefaultAccount;
import com.blinfosoft.feedback.entity.DefaultUser;
import com.blinfosoft.feedback.entity.impl.App;
import com.blinfosoft.feedback.entity.impl.User;
import com.blinfosoft.feedback.exception.NoAppFound;
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
    public Optional<List<User>> findByAccountId(long id) throws NoAppFound {
        return execute((em) -> {
            Query query = em.createNativeQuery("SELECT * FROM user WHERE Account_Id = \'" + id + "\'", DefaultUser.class);
            List<User> user = query.getResultList();
            return user;
        });
    }
    
}
