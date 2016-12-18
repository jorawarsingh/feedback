/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.api;

import com.blinfosoft.feedback.db.IssueEntityManagerFactory;
import com.blinfosoft.feedback.dto.out.DTOFactory;
import com.blinfosoft.feedback.entity.Admin;
import com.blinfosoft.feedback.service.AdminService;
import java.util.List;
import javax.ws.rs.GET;
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
}
