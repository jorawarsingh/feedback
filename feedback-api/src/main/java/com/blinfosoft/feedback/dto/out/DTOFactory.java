/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.dto.out;

import com.blinfosoft.feedback.dao.DaoFactory;
import com.blinfosoft.feedback.dao.FeedbackEntityManagerFactory;
import com.blinfosoft.feedback.entity.impl.Account;
import com.blinfosoft.feedback.entity.impl.App;
import com.blinfosoft.feedback.entity.impl.Issue;
import com.blinfosoft.feedback.entity.impl.User;
import com.blinfosoft.feedback.exception.AppNotFoundException;
import com.blinfosoft.feedback.service.IssueService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author js
 */
public class DTOFactory {

    IssueService issueService = new IssueService(new DaoFactory(FeedbackEntityManagerFactory.getInstance()));

    public AccountDTO getAccount(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setEmail(account.getEmail());
        accountDTO.setName(account.getAccountName());
        accountDTO.setLicense(account.getLicense());
        return accountDTO;
    }

    public List<AccountDTO> getAdminList(List<Account> adminList) {
        List<AccountDTO> adminListDTO = new ArrayList<AccountDTO>();
        adminList.stream().forEach((account) -> {
            adminListDTO.add(getAccount(account));
        });
        return adminListDTO;
    }

    public AppDTO getApp(App app) throws AppNotFoundException {
        AppDTO appDTO = new AppDTO();
        appDTO.setIssueList(getIssueList(new ArrayList<>(app.getIssue())));
        appDTO.setId(app.getId());
        appDTO.setName(app.getName());

        return appDTO;
    }

    public List<AppDTO> getAppList(List<App> appList) {
        List<AppDTO> appListDTO = new ArrayList<>();
        appList.stream().forEach((app) -> {
            try {
                appListDTO.add(getApp(app));
            } catch (AppNotFoundException ex) {
                Logger.getLogger(DTOFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return appListDTO;
    }
    
    public IssueDTO getIssue(Issue issue) {
        IssueDTO issueDTO = new IssueDTO();
        issueDTO.setId(issue.getId());
        issueDTO.setTitle(issue.getTitle());
        return issueDTO;
    }

    public List<IssueDTO> getIssueList(List<Issue> issueList) {
        List<IssueDTO> issueListDTO = new ArrayList<>();
        issueList.stream().forEach((app) -> {
            issueListDTO.add(getIssue(app));
        });
        return issueListDTO;
    }

    public UserDTO getUser(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public List<UserDTO> getUserList(List<User> user) {
        List<UserDTO> list = new ArrayList<>();
        user.stream().forEach((u) -> {
            list.add(getUser(u));
        });
        return list;
    }
}
