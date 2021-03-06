/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.api;

import com.blinfosoft.feedback.dao.DaoFactory;
import com.blinfosoft.feedback.dao.FeedbackEntityManagerFactory;
import com.blinfosoft.feedback.dto.out.DTOFactory;
import com.blinfosoft.feedback.entity.DefaultApp;
import com.blinfosoft.feedback.entity.DefaultIssue;
import com.blinfosoft.feedback.entity.impl.Issue;
import com.blinfosoft.feedback.service.IssueService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author js
 */
@Path("/issue")
public class IssueResources {
    private final IssueService issueService = new IssueService(new DaoFactory(FeedbackEntityManagerFactory.getInstance()));
    @GET
    @Path("/{param}")
    @Produces("application/json")
    public Response getIssuesByAccount(@PathParam("param") long appId) {
        try {
           List<Issue> issue = issueService.getIssueByAppId(appId);
            return Response.ok(new DTOFactory().getIssueList(issue)).build();
        } catch (Exception e) {
            return Response.serverError().entity(e).build();
        }        
    } 
  /*  @GET
    @Path("user/{param}")
    @Produces("application/json")
    public Response getIssuesByUser(@PathParam("param") long userId) {
        try {
           List<Issue> issue = issueService.getIssueByUserId(userId);
            return Response.ok(new DTOFactory().getIssueList(issue)).build();
        } catch (Exception e) {
            return Response.serverError().entity(e).build();
        }        
    } */
}
