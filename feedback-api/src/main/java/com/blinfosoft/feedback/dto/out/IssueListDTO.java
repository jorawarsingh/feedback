/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.dto.out;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author js
 */
public class IssueListDTO {
     private final List<IssueDTO> issueList = new ArrayList<>();
   public List<IssueDTO> getIssueList() {
        return issueList;
    }
    public void add(IssueDTO issueDTO){
        issueList.add(issueDTO);
    } 
}
