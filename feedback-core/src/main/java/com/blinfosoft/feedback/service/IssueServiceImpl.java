/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.entity.DefaultIssue;
import com.blinfosoft.feedback.entity.DefaultUser;
import com.blinfosoft.feedback.entity.impl.Issue;
import com.blinfosoft.feedback.exception.AppNotFoundException;
import com.blinfosoft.feedback.exception.IssueNotFoundExceptions;
import java.util.List;

/**
 *
 * @author js
 */
public interface IssueServiceImpl {

    Issue getIssue(long id) throws IssueNotFoundExceptions;

    List<Issue> getIssueByAppId(long appId) throws AppNotFoundException;

    //List<Issue> getIssueByUserId(long userId);

    void deleteIssue(long id) throws IssueNotFoundExceptions;

    Issue createIssue(Issue issue, long appId, long userId);

    Issue updateIssue(Issue issue);
}
