/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.api;

import com.blinfosoft.feedback.dao.DaoFactory;
import com.blinfosoft.feedback.dao.FeedbackEntityManagerFactory;
import com.blinfosoft.feedback.dto.in.CreateAccountDTO;
import com.blinfosoft.feedback.dto.out.DTOFactory;
import com.blinfosoft.feedback.entity.impl.Account;
import com.blinfosoft.feedback.exception.AccountNotFoundException;
import com.blinfosoft.feedback.exception.InValidCredantialsExcetions;
import com.blinfosoft.feedback.service.AccountService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author js
 */
@Path("/login")
public class LoginResources {

    private final AccountService accountService = new AccountService(new DaoFactory(FeedbackEntityManagerFactory.getInstance()));

    @POST
    @Consumes("application/json")
    @Produces("application/json")   
    public Response login(CreateAccountDTO indata) throws InValidCredantialsExcetions, AccountNotFoundException {
        Account account = accountService.login(indata.getEmail(), indata.getPassword());
        return Response.ok(new DTOFactory().getAccount(account)).build();
    }
}
