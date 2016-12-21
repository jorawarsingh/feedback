/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.api;

import com.blinfosoft.feedback.dao.DaoFactory;
import com.blinfosoft.feedback.dao.FeedbackEntityManagerFactory;
import com.blinfosoft.feedback.dto.in.CreateAccountDTO;
import com.blinfosoft.feedback.dto.in.CreateAppDTO;
import com.blinfosoft.feedback.dto.out.AppListDTO;
import com.blinfosoft.feedback.dto.out.DTOFactory;
import com.blinfosoft.feedback.entity.DefaultAccount;
import com.blinfosoft.feedback.entity.DefaultApp;
import com.blinfosoft.feedback.entity.impl.Account;
import com.blinfosoft.feedback.exception.AccountNotFoundException;
import com.blinfosoft.feedback.exception.FeedbackException;
import com.blinfosoft.feedback.service.AccountService;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author js
 */
@Path("/accounts")
public class AccountResources {

    private final AccountService accountService = new AccountService(new DaoFactory(FeedbackEntityManagerFactory.getInstance()));

    @GET
    @Produces("application/json")
    public Response getAccountList() {
        try {
            List<Account> account = accountService.getAccounts();
            return Response.ok(new DTOFactory().getAdminList(account)).build();
        } catch (FeedbackException e) {
            return Response.serverError().entity("{\"error\": \"" + e.getMessage() + "\",\"cause\": \"" + e.getCauseMsg() + "\"}").build();
        }

    }
    @GET
    @Path("/{param}")
    @Produces("application/json")
    public Response getAccount(@PathParam("param") long id) throws AccountNotFoundException {
        System.out.println("here");
        try {
            Account account = accountService.getAccount(id);
            System.out.println(account.getLicense());
            return Response.ok(new DTOFactory().getAccount(account)).build();
        } catch (FeedbackException e) {
            return Response.serverError().entity("{\"error\": \"" + e.getMessage() + "\",\"cause\": \"" + e.getCauseMsg() + "\"}").build();
        }
    }
    @DELETE
    @Path("/{param}")
    @Produces("application/json")
    public Response deleteAccount(@PathParam("param") long id) throws AccountNotFoundException {
        try {
            accountService.deleteAccount(id);
            return Response.ok().build();
        } catch (FeedbackException e) {
            return Response.serverError().entity("{\"error\": \"" + e.getMessage() + "\",\"cause\": \"" + e.getCauseMsg() + "\"}").build();
        }
    }
    @PUT
    @Path("/{param}")
    @Produces("application/json")
    public Response updateAccount(@PathParam("param") long id, Account indata) throws AccountNotFoundException {
        try {
           Account account =  accountService.updateAccount(indata);
            return Response.ok(new DTOFactory().getAccount(account)).build();
        } catch (FeedbackException e) {
            return Response.serverError().entity("{\"error\": \"" + e.getMessage() + "\",\"cause\": \"" + e.getCauseMsg() + "\"}").build();
        }
    }
    

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createAdminAndApp(CreateAccountDTO adminDTOInput) throws AccountNotFoundException {
        Account account = null;
        try {
            boolean alreadyExist = accountService.accountAlreadyExist(adminDTOInput.getUserName());
            if (!alreadyExist) {
                account = new DefaultAccount();
                UUID randomUUID = UUID.randomUUID();
                account.setEmail(adminDTOInput.getEmail());
                account.setPassword(adminDTOInput.getPassword());
                account.setAccountName(adminDTOInput.getUserName());
                account.setLicense(randomUUID.toString());
                accountService.createAccount(account);
            } else {
                return Response.serverError().entity("{\"error\": \"account alreay exist\"}").build();
            }
            return Response.ok(new DTOFactory().getAccount(account)).build();
        } catch (FeedbackException e) {
            return Response.serverError().entity("{\"error\": \"" + e.getMessage() + "\",\"cause\": \"" + e.getCauseMsg() + "\"}").build();
        }
    }
}
