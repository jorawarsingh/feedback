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
import com.blinfosoft.feedback.entity.impl.App;
import com.blinfosoft.feedback.exception.AccountNotFoundException;
import com.blinfosoft.feedback.exception.AppAlreadyExistExceptions;
import com.blinfosoft.feedback.exception.AppNotFoundException;
import com.blinfosoft.feedback.exception.FeedbackException;
import com.blinfosoft.feedback.service.AppService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author js
 */
@Path("/apps")
public class AppResources {
    private final AppService appService = new AppService(new DaoFactory(FeedbackEntityManagerFactory.getInstance()));
   /*@GET
    @Produces("application/json")
    public Response getAppList() {
        try {
            List<App> app = appService.getApps();
            //   admin.forEach(item->System.out.println(item.getName()));
            return Response.ok(new DTOFactory().getAppList(app)).build();
        } catch (Exception e) {
            return Response.serverError().entity("error").build();
        }        
    } */
    @GET
    @Produces("application/json")
    public Response getAppsByAccount(@HeaderParam("authorization") String userAgent) {
        try {
            List<App> app = appService.getAppsByAccount(userAgent);
            //   admin.forEach(item->System.out.println(item.getName()));
            return Response.ok(new DTOFactory().getAppList(app)).build();
        } catch (Exception e) {
            return Response.serverError().entity(e).build();
        }        
    } 
    @POST
    @Produces("application/json")
    public Response createAppsByAccount(@HeaderParam("authorization") String userAgent,@PathParam("param") long id, DefaultApp indata)throws AppAlreadyExistExceptions, AccountNotFoundException, AppNotFoundException {
        try {
            App app = appService.createAppByAccount(indata , userAgent);
            return Response.ok(new DTOFactory().getApp(app)).build();
        } catch (FeedbackException e) {
            return Response.serverError().entity(e).build();
        }        
    } 
}
