/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.service;

import com.blinfosoft.feedback.entity.DefaultIssue;
import com.blinfosoft.feedback.entity.DefaultUser;
import java.util.List;

/**
 *
 * @author js
 */
public interface IssueServiceImpl {

    List<DefaultIssue> getIssues();

    DefaultIssue getIssue(long id);

    List<DefaultIssue> getIssueByAppId(long appId);

    List<DefaultIssue> getIssueByUserId(long userId);

    void deleteIssue(long id);

    DefaultIssue createIssue(DefaultIssue issue, long appId, long userId);

    DefaultIssue updateIssue(DefaultIssue issue);
}
