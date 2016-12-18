/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.entity.Issue;
import com.blinfosoft.feedback.entity.User;
import java.util.List;

/**
 *
 * @author js
 */
public interface IssueServiceImpl {

    List<Issue> getIssues();

    Issue getIssue(long id);

    List<Issue> getIssueByAppId(long appId);

    List<Issue> getIssueByUserId(long userId);

    void deleteIssue(long id);

    Issue createIssue(Issue issue, long appId, long userId);

    Issue updateIssue(Issue issue);
}
