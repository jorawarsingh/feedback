/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.dto.out;

import com.blinfosoft.feedback.entity.Account;
import com.blinfosoft.feedback.entity.App;
import com.blinfosoft.feedback.entity.Issue;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author js
 */
public class DTOFactory {

    public AccountDTO getAdmin(Account admin) {
        AccountDTO adminDTO = new AccountDTO();
        adminDTO.setId(admin.getId());
        adminDTO.setName(admin.getName());
        return adminDTO;
    }

    public List<AccountDTO> getAdminList(List<Account> adminList) {
        List<AccountDTO> adminListDTO = new ArrayList<AccountDTO>();
        adminList.stream().forEach((admin) -> {
            adminListDTO.add(getAdmin(admin));
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
}
