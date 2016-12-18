/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.dto.out;

import com.blinfosoft.feedback.entity.Admin;
import com.blinfosoft.feedback.entity.App;
import com.blinfosoft.feedback.entity.Issue;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author js
 */
public class DTOFactory {

    public AdminDTO getAdmin(Admin admin) {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId(admin.getId());
        adminDTO.setName(admin.getName());
        return adminDTO;
    }

    public AdminListDTO getAdminList(List<Admin> adminList) {
        AdminListDTO adminListDTO = new AdminListDTO();
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

    public AppListDTO getAppList(List<App> appList) {
        AppListDTO appListDTO = new AppListDTO();
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

    public IssueListDTO getIssueList(List<Issue> issueList) {
        IssueListDTO issueListDTO = new IssueListDTO();
        issueList.stream().forEach((app) -> {
            issueListDTO.add(getIssue(app));
        });
        return issueListDTO;
    }
}
