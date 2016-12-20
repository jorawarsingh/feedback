/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.dto.out;

import com.blinfosoft.feedback.entity.DefaultAccount;
import com.blinfosoft.feedback.entity.DefaultApp;
import com.blinfosoft.feedback.entity.DefaultIssue;
import com.blinfosoft.feedback.entity.impl.Account;
import com.blinfosoft.feedback.entity.impl.App;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author js
 */
public class DTOFactory {

    public AccountDTO getAccount(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setEmail(account.getEmail());
        accountDTO.setName(account.getAccountName());
        accountDTO.setUserName(account.getAccountName());
        return accountDTO;
    }

    public List<AccountDTO> getAdminList(List<Account> adminList) {
        List<AccountDTO> adminListDTO = new ArrayList<AccountDTO>();
        adminList.stream().forEach((account) -> {
            adminListDTO.add(getAccount(account));
        });
        return adminListDTO;
    }
    public AppDTO getApp(App app) {
        AppDTO appDTO = new AppDTO();
        appDTO.setId(app.getId());
        appDTO.setName(app.getName());
        return appDTO;
    }

    public List<AppDTO> getAppList(List<App> appList) {
        List<AppDTO> appListDTO = new ArrayList<>();
        appList.stream().forEach((app) -> {
            appListDTO.add(getApp(app));
        });
        return appListDTO;
    }
    
    public IssueDTO getIssue(DefaultIssue issue) {
        IssueDTO issueDTO = new IssueDTO();
        issueDTO.setId(issue.getId());
        issueDTO.setTitle(issue.getTitle());
        return issueDTO;
    }

    public List<IssueDTO> getIssueList(List<DefaultIssue> issueList) {
        List<IssueDTO> issueListDTO = new ArrayList<>();
        issueList.stream().forEach((app) -> {
            issueListDTO.add(getIssue(app));
        });
        return issueListDTO;
    }
}
