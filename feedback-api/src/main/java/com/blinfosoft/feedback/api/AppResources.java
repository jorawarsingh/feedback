/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.api;

import com.blinfosoft.feedback.dao.FeedbackEntityManagerFactory;
import com.blinfosoft.feedback.dto.out.DTOFactory;
import com.blinfosoft.feedback.entity.impl.App;
import com.blinfosoft.feedback.service.AppService;
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
@Path("/app")
public class AppResources {
    private final AppService adminService = new AppService(FeedbackEntityManagerFactory.getInstance());
    @GET
    @Produces("application/json")
    public Response getAppList() {
        try {
            List<App> app = adminService.getApps();
            //   admin.forEach(item->System.out.println(item.getName()));
            return Response.ok(new DTOFactory().getAppList(app)).build();
        } catch (Exception e) {
            return Response.serverError().entity("error").build();
        }        
    } 
    @GET
    @Path("/{param}")
    @Produces("application/json")
    public Response getAppByAdmin(@PathParam("param") long id) {
        try {
            List<App> app = adminService.getAppsByAdmin(id);
            //   admin.forEach(item->System.out.println(item.getName()));
            return Response.ok(new DTOFactory().getAppList(app)).build();
        } catch (Exception e) {
            return Response.serverError().entity(e).build();
        }        
    } 
}
