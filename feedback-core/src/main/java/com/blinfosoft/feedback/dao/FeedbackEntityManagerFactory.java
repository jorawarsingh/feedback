/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.dao;

import com.blinfosoft.feedback.mysql.MysqlProperties;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author js
 */
public class FeedbackEntityManagerFactory {
    private static final class FeedbackEntityManagerFactoryLoader{
         private static final String WEBBTID_PERSISTANCE_UNIT = "com.blinfosoft-jpa";
        private static final EntityManagerFactory INSTANCE = Persistence.createEntityManagerFactory(WEBBTID_PERSISTANCE_UNIT, new MysqlProperties().getProperties());
    }
    private FeedbackEntityManagerFactory() {
        if (FeedbackEntityManagerFactoryLoader.INSTANCE != null) {
            throw new IllegalStateException("EntityManagerFactory already instantiated");
        }
    }

    public static EntityManagerFactory getInstance() {
        return FeedbackEntityManagerFactoryLoader.INSTANCE;
    }
}