/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.dao;

import com.blinfosoft.feedback.entity.DefaultAccount;
import com.blinfosoft.feedback.entity.DefaultIssue;
import com.blinfosoft.feedback.entity.impl.Issue;
import com.blinfosoft.feedback.exception.AppNotFoundException;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author js
 */
public class IssueDao extends GenericDao<DefaultIssue, Long> {

    public IssueDao(EntityManagerFactory entityManagerFactory) {
        super(DefaultIssue.class, entityManagerFactory);
    }

    public Optional<DefaultIssue> findByAppName(String title) throws AppNotFoundException {
        final String queryStr = title != null ? title.trim() : null;
        return execute((em) -> {
            Query query = em.createNativeQuery("SELECT * FROM issue WHERE title = \'" + queryStr + "\'", DefaultIssue.class);
            DefaultIssue issue = (DefaultIssue) query.getSingleResult();
            return issue;
        });
    }
    public Optional<List<Issue>> findIssueByAppId(long appId) throws AppNotFoundException {
        return execute((em) -> {
            Query query = em.createNativeQuery("SELECT * FROM issue WHERE App_Id = \'" + appId + "\'", DefaultIssue.class);
            List<Issue> issue =  query.getResultList();
            return issue;
        });
    }
}
