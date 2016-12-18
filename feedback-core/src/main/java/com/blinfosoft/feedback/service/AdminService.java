/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.entity.App;
import com.blinfosoft.feedback.entity.Admin;
import com.blinfosoft.feedback.exception.FeedbackException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author js
 */
public class AdminService implements AdminServiceImpl {

    private final EntityManagerFactory emf;

    public AdminService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public Admin createUser(Admin admin) {

        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(admin);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return admin;
    }

    @Override
    public void deleteUser(long adminId) {
        EntityManager em = null;
        Admin admin = null;
        try {
            em = getEntityManager();
            admin = em.find(Admin.class, adminId);
            em.getTransaction().begin();
            em.remove(admin);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new FeedbackException("could not delete admin with id: " + adminId, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Admin updateUser(Admin admin) {
         EntityManager em = null;
        try {
            em = getEntityManager();
//            session = em.find(Session.class, s.getUUID());
            em.getTransaction().begin();
            admin = em.merge(admin);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new FeedbackException("cound not update" + admin, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return admin;
    }

    @Override
    public Admin getUser(long adminId) {
         EntityManager em = null;
        try {
            em = getEntityManager();
            em.clear();
            Admin admin = em.find(Admin.class, adminId);
            return admin;
        } catch (Exception e) {
            throw new FeedbackException("could not find admin with id :- " + adminId, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Admin> getUsers() {
        EntityManager em = null;
        TypedQuery<Admin> query = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            query = em.createQuery("from Admin", Admin.class);
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
    public Admin createUserAndApp(Admin admin, App app) {
        EntityManager em = null;
        Collection<App> apps = new LinkedHashSet<>();
        apps.add(app);
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            admin.setApp(apps);
            em.persist(admin);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return admin;
    }

    @Override
    public Admin getUserByUserName(String userName) {
        EntityManager em = null;
        String q = "SELECT a FROM Admin a where userName = "+userName;
        TypedQuery<Admin> query = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            query = em.createQuery(q, Admin.class);
            em.getTransaction().commit();
            return query.getSingleResult();
        } catch (Exception e) {
            throw new FeedbackException("unknown error", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
