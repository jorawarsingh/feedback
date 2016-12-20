/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.entity.DefaultApp;
import com.blinfosoft.feedback.entity.DefaultAccount;
import com.blinfosoft.feedback.entity.impl.Account;
import com.blinfosoft.feedback.entity.impl.App;
import com.blinfosoft.feedback.exception.FeedbackException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author js
 */
public class AppService implements AppServiceImpl {

    private final EntityManagerFactory emf;

    public AppService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public DefaultApp getApp(long id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.clear();
            DefaultApp app = em.find(DefaultApp.class, id);
            return app;
        } catch (Exception e) {
            throw new FeedbackException("could not find app with id :- " + id, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void deleteApp(long id) {
        EntityManager em = null;
        App app = null;
        try {
            em = getEntityManager();
            app = em.find(DefaultApp.class, id);
            em.getTransaction().begin();
            em.remove(app);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new FeedbackException("could not delete user with id: " + id, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public App createApp(App app) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(app);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return app;
    }

    @Override
    public App updateApp(App app) {
        EntityManager em = null;
        try {
            em = getEntityManager();
//            session = em.find(Session.class, s.getUUID());
            em.getTransaction().begin();
            app = em.merge(app);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new FeedbackException("cound not update" + app, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return app;
    }

    @Override
    public List<App> getApps() {
        EntityManager em = null;
        TypedQuery<App> query = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            query = em.createQuery("from App", App.class);
            em.getTransaction().commit();
            return query.getResultList();
        } catch (Exception e) {
            throw new FeedbackException("unknown error", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public App createAppByUser(App app, long userId) {
      
        return app;
    }

    @Override
    public List<App> getAppsByAdmin(long adminId) {
        EntityManager em = null;
        String q = "SELECT a FROM App a where Admin_Id = "+adminId;
        TypedQuery<App> query = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            query = em.createQuery(q, App.class);
            em.getTransaction().commit();
            return query.getResultList();
        } catch (Exception e) {
            throw new FeedbackException("unknown error", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
