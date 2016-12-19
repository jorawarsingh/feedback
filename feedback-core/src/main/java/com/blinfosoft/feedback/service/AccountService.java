/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.entity.App;
import com.blinfosoft.feedback.entity.Account;
import com.blinfosoft.feedback.exception.FeedbackException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.hibernate.NonUniqueResultException;

/**
 *
 * @author js
 */
public class AccountService implements AccountServiceImpl {

    private final EntityManagerFactory emf;

    public AccountService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public Account createAccount(Account admin) {

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
    public void deleteAccount(long adminId) {
        EntityManager em = null;
        Account admin = null;
        try {
            em = getEntityManager();
            admin = em.find(Account.class, adminId);
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
    public Account updateAccount(Account admin) {
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
    public Account getAccount(long adminId) {
         EntityManager em = null;
        try {
            em = getEntityManager();
            em.clear();
            Account admin = em.find(Account.class, adminId);
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
    public List<Account> getAccounts() {
        EntityManager em = null;
        TypedQuery<Account> query = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            query = em.createQuery("from Admin", Account.class);
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
    public Account createAccountAndApp(Account admin, App app) {
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
    public Account getAccountByName(String userName) {
        EntityManager em = null;
        String hql = "FROM Account A Where A.userName = :userName";
        TypedQuery<Account> query = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            query = em.createQuery(hql, Account.class);
            query.setParameter("userName", userName);
            em.getTransaction().commit();
           List<Account> account = query.getResultList();
           if(account.isEmpty()){
               return null;
           }else{
             return account.get(0);
           }            
        } catch (NonUniqueResultException nure) {
            throw new FeedbackException("no app found with name "+  userName , nure);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
