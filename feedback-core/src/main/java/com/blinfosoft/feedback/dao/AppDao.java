/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.dao;

import com.blinfosoft.feedback.entity.DefaultAccount;
import com.blinfosoft.feedback.entity.DefaultApp;
import com.blinfosoft.feedback.entity.impl.App;
import com.blinfosoft.feedback.exception.AppNotFoundException;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author js
 */
public class AppDao extends GenericDao<App, Long>{

    public AppDao(EntityManagerFactory emFactory) {
        super(DefaultApp.class, emFactory);
    }
    public Optional<DefaultApp> findByAppName(String name) throws AppNotFoundException {
        final String queryStr = name != null ? name.trim() : null;
        return execute((em) -> {
            Query query = em.createNativeQuery("SELECT * FROM app WHERE name = \'" + queryStr + "\'", DefaultApp.class);
            DefaultApp app = (DefaultApp) query.getSingleResult();
            return app;
        });
    }
    public Optional<List<App>> findByAccountLicense(String userAgent) throws AppNotFoundException {
        return execute((em) -> {
            Query query = em.createNativeQuery("SELECT * FROM app a join account ac on a.Account_Id = ac.Account_Id WHERE ac.license = \'" + userAgent + "\'", DefaultApp.class);
            List<App> app = query.getResultList();
            return app;
        });
    }
}
