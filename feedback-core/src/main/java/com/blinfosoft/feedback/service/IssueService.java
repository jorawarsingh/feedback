/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.dao.DaoFactory;
import com.blinfosoft.feedback.entity.DefaultIssue;
import com.blinfosoft.feedback.entity.impl.Issue;
import com.blinfosoft.feedback.exception.AppNotFoundException;
import com.blinfosoft.feedback.exception.IssueNotFoundExceptions;
import java.util.List;

/**
 *
 * @author js
 */
public class IssueService implements IssueServiceImpl {

    private final DaoFactory daoFactory;

    protected DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public IssueService(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Issue getIssue(long id) throws IssueNotFoundExceptions{
        return getDaoFactory().getIssueDao().findByPrimaryKey(id).orElseThrow(() ->{
            return new IssueNotFoundExceptions(id);
        });
    }

    @Override
    public void deleteIssue(long id) throws IssueNotFoundExceptions{
        DefaultIssue issue = getDaoFactory().getIssueDao().findByPrimaryKey(id).orElseThrow(() -> {
            return new IssueNotFoundExceptions(id);
        });
      getDaoFactory().getIssueDao().destroy(issue);
    }

    @Override
    public Issue createIssue(Issue issue, long appId, long userId) {

        return issue;
    }

    @Override
    public Issue updateIssue(Issue issue) {
        return issue;
    }

    @Override
    public List<Issue> getIssueByAppId(long appId) throws AppNotFoundException{
        return getDaoFactory().getIssueDao().findIssueByAppId(appId).orElseThrow(()-> {
            return new AppNotFoundException(appId);
        });
    }
}
