/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.dao;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author js
 */
public class DaoFactory {
    private final EntityManagerFactory emFactory;

    public DaoFactory(EntityManagerFactory emf) {
        this.emFactory = emf;
    }

    public AccountDao getAccountDao() {
        return new AccountDao(emFactory);
    }
}
