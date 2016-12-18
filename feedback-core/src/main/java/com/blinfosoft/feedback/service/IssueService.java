/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.entity.App;
import com.blinfosoft.feedback.entity.Issue;
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
public class IssueService implements IssueServiceImpl {

    private final EntityManagerFactory emf;

    public IssueService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public List<Issue> getIssues() {
        EntityManager em = null;
        TypedQuery<Issue> query = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            query = em.createQuery("from Issue", Issue.class);
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
    public Issue getIssue(long id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.clear();
            Issue issue = em.find(Issue.class, id);
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
        Issue issue = null;
        try {
            em = getEntityManager();
            issue = em.find(Issue.class, id);
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
    public Issue createIssue(Issue issue, long appId, long userId) {
        EntityManager em = null;
        App app = new App();
        User user = new User();
        AppService appService = new AppService(emf);
        UserService userService = new UserService(emf);
        try {
            user = userService.getUser(userId);
            app = appService.getApp(appId);
            issue.setApp(app);
            issue.setUser(user);
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(issue);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return issue;
    }

    @Override
    public Issue updateIssue(Issue issue) {
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
    public List<Issue> getIssueByAppId(long appId) {
         EntityManager em = null;
        String q = "SELECT i FROM Issue i where App_Id = "+appId;
        TypedQuery<Issue> query = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            query = em.createQuery(q, Issue.class);
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
    public List<Issue> getIssueByUserId(long userId) {
         EntityManager em = null;
        String q = "SELECT i FROM Issue i where User_Id = "+userId;
        TypedQuery<Issue> query = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            query = em.createQuery(q, Issue.class);
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
