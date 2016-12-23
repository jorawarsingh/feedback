/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.api;

import com.blinfosoft.feedback.dao.DaoFactory;
import com.blinfosoft.feedback.dao.FeedbackEntityManagerFactory;
import com.blinfosoft.feedback.dto.in.CreateUserDTO;
import com.blinfosoft.feedback.dto.out.DTOFactory;
import com.blinfosoft.feedback.entity.DefaultUser;
import com.blinfosoft.feedback.entity.impl.User;
import com.blinfosoft.feedback.exception.AccountNotFoundException;
import com.blinfosoft.feedback.service.UserService;
import java.util.ArrayList;
import java.util.List;
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
@Path("/users")
public class UserResources {

    private final UserService userService = new UserService(new DaoFactory(FeedbackEntityManagerFactory.getInstance()));

    @GET
    @Produces("application/json")
    public Response getUsers() throws AccountNotFoundException {
       List<User> users = userService.getUsers(1);
        return Response.ok(new DTOFactory().getUserList(users)).build();
    }
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response createUsers(CreateUserDTO userIndata) throws AccountNotFoundException {   
        User user = new DefaultUser();
        user.setFirstName(userIndata.getFirstName());
        user.setEmail(userIndata.getEmail());
        user.setLastName(userIndata.getLastName());
        user.setUserName(userIndata.getUserName());
        user = userService.createUser(user, 1);
        return Response.ok(user).build();
    }
}
