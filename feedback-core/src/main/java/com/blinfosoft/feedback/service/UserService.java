/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.entity.Account;
import com.blinfosoft.feedback.entity.User;
import com.blinfosoft.feedback.exception.FeedbackException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author js
 */
public class UserService implements UserImpl {

    private final EntityManagerFactory emf;

    public UserService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public User getUser(long userId) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.clear();
            User user = em.find(User.class, userId);
            return user;
        } catch (Exception e) {
            throw new FeedbackException("could not find user with id :- " + userId, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<User> getUsers() {
        EntityManager em = null;
        TypedQuery<User> query = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            query = em.createQuery("from User", User.class);
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
    public User createUser(User user) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return user;
    }

    @Override
    public User updateUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(long userId) {
           EntityManager em = null;
        User user = null;
        try {
            em = getEntityManager();
            user = em.find(User.class, userId);
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new FeedbackException("could not delete user with id: " + userId, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
