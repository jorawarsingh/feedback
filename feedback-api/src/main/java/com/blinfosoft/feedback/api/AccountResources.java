/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.api;

import com.blinfosoft.feedback.db.IssueEntityManagerFactory;
import com.blinfosoft.feedback.dto.in.CreateAccountDTO;
import com.blinfosoft.feedback.dto.in.CreateAppDTO;
import com.blinfosoft.feedback.dto.out.AppListDTO;
import com.blinfosoft.feedback.dto.out.DTOFactory;
import com.blinfosoft.feedback.entity.Account;
import com.blinfosoft.feedback.entity.App;
import com.blinfosoft.feedback.exception.FeedbackException;
import com.blinfosoft.feedback.service.AccountService;
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
public class AccountResources {

    private final AccountService accountService = new AccountService(IssueEntityManagerFactory.getEmf());

    @GET
    @Produces("application/json")
    public Response getAdmiList() {
        try {
            List<Account> admin = accountService.getAccounts();
            //   admin.forEach(item->System.out.println(item.getName()));
            return Response.ok(new DTOFactory().getAdminList(admin)).build();
        } catch (FeedbackException e) {
            return Response.serverError().entity("{\"error\": \"" + e.getMessage() + "\",\"cause\": \"" + e.getCauseMsg() + "\"}").build();
        }

    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createAdminAndApp(CreateAccountDTO adminDTOInput) {
        try {
            Account account = accountService.getAccountByName(adminDTOInput.getUserName());
            if (account == null) {
                account = new Account();
                      
                UUID randomUUID = UUID.randomUUID();
                account.setEmail(adminDTOInput.getEmail());
                account.setPassword(adminDTOInput.getPassword());
                account.setUserName(adminDTOInput.getUserName());
                account.setUserSecretKey(randomUUID.toString());
                accountService.createAccount(account);
            }
            return Response.serverError().entity(account).build();
        } catch (FeedbackException e) {
            return Response.serverError().entity("{\"error\": \"" + e.getMessage() + "\",\"cause\": \"" + e.getCauseMsg() + "\"}").build();
        }
    }
}
