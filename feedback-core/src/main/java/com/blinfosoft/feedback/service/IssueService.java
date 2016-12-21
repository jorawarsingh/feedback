/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.entity.DefaultApp;
import com.blinfosoft.feedback.entity.DefaultIssue;
import com.blinfosoft.feedback.entity.DefaultUser;
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
public class IssueService implements IssueServiceImpl {

    private final EntityManagerFactory emf;

    public IssueService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public List<DefaultIssue> getIssues() {
        EntityManager em = null;
        TypedQuery<DefaultIssue> query = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            query = em.createQuery("from Issue", DefaultIssue.class);
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
    public DefaultIssue getIssue(long id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.clear();
            DefaultIssue issue = em.find(DefaultIssue.class, id);
            return issue;
        } catch (Exception e) {
            throw new FeedbackException("could not find issue with id :- " + id, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void deleteIssue(long id) {
        EntityManager em = null;
        DefaultIssue issue = null;
        try {
            em = getEntityManager();
            issue = em.find(DefaultIssue.class, id);
            em.getTransaction().begin();
            em.remove(issue);
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
    public DefaultIssue createIssue(DefaultIssue issue, long appId, long userId) {
    
        return issue;
    }

    @Override
    public DefaultIssue updateIssue(DefaultIssue issue) {
        EntityManager em = null;
        try {
            em = getEntityManager();
//            session = em.find(Session.class, s.getUUID());
            em.getTransaction().begin();
            issue = em.merge(issue);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new FeedbackException("cound not update" + issue, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return issue;
    }

    @Override
    public List<DefaultIssue> getIssueByAppId(long appId) {
         EntityManager em = null;
        String q = "SELECT i FROM Issue i where App_Id = "+appId;
        TypedQuery<DefaultIssue> query = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            query = em.createQuery(q, DefaultIssue.class);
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
    public List<DefaultIssue> getIssueByUserId(long userId) {
         EntityManager em = null;
        String q = "SELECT i FROM Issue i where User_Id = "+userId;
        TypedQuery<DefaultIssue> query = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            query = em.createQuery(q, DefaultIssue.class);
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
