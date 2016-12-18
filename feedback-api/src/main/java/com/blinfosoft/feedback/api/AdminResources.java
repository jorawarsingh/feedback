/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.api;

import com.blinfosoft.feedback.db.IssueEntityManagerFactory;
import com.blinfosoft.feedback.dto.in.CreateAdminDTO;
import com.blinfosoft.feedback.dto.in.CreateAppDTO;
import com.blinfosoft.feedback.dto.out.AppListDTO;
import com.blinfosoft.feedback.dto.out.DTOFactory;
import com.blinfosoft.feedback.entity.Admin;
import com.blinfosoft.feedback.entity.App;
import com.blinfosoft.feedback.service.AdminService;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author js
 */
@Path("/admin")
public class AdminResources {

    private final AdminService adminService = new AdminService(IssueEntityManagerFactory.getEmf());

    @GET
    @Produces("application/json")
    public Response getAdmiList() {
        try {
            List<Admin> admin = adminService.getUsers();
            //   admin.forEach(item->System.out.println(item.getName()));
            return Response.ok(new DTOFactory().getAdminList(admin)).build();
        } catch (Exception e) {
            return Response.serverError().entity("error").build();
        }

    }

    @POST
    @Path("/app")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createAdminAndApp(CreateAdminDTO adminDTOInput, CreateAppDTO appDTOInput) {
        try {
            Admin admin = adminService.getUserByUserName(adminDTOInput.getUserName());
            App  app = new App();
            if (admin == null) {
                UUID randomUUID = UUID.randomUUID();
                admin.setEmail(adminDTOInput.getEmail());
                admin.setPassword(adminDTOInput.getPassword());
                admin.setUserName(adminDTOInput.getUserName());
                admin.setUserSecretKey(randomUUID.toString());
                app.setName(appDTOInput.getName());
                app.setAdmin(admin);
                adminService.createUserAndApp(admin, app);
            }
            return Response.serverError().entity(admin).build();
        } catch (Exception e) {
            return Response.serverError().entity("error").build();
        }
    }
}
