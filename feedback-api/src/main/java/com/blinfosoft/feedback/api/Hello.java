/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.api;

import com.blinfosoft.feedback.entity.DefaultIssue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author js
 */
@Path("/hello")
public class Hello {
    private DefaultIssue issue = new DefaultIssue();
    @GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
		issue.setTitle(msg);
		return Response.status(200).entity("q").build();
	}
}
