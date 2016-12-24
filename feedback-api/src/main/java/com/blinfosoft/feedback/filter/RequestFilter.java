/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.filter;

import com.blinfosoft.feedback.dao.DaoFactory;
import com.blinfosoft.feedback.dao.FeedbackEntityManagerFactory;
import com.blinfosoft.feedback.service.AccountService;
import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author js
 */
public class RequestFilter implements ContainerRequestFilter {

    public static final String AUTHENTICATION_HEADER = "authorization";
    private final AccountService accountService = new AccountService(new DaoFactory(FeedbackEntityManagerFactory.getInstance()));

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authCredentails = requestContext.getHeaderString(AUTHENTICATION_HEADER);
        UriInfo uri = requestContext.getUriInfo();
        String currentMethod = requestContext.getMethod();
        String path = uri.getPath();
        if (!allowRoot(path)) {
            if (!allowOptions(currentMethod)) {
                if (!allowToCreateAccount(path, currentMethod)) {
                    if (!accountService.verfyAccount(authCredentails)) {
                        abortMission(requestContext);
                    }
                }
            }
        }
    }

    private void abortMission(ContainerRequestContext requestContext) {
        requestContext.abortWith(Response
                .status(Response.Status.UNAUTHORIZED)
                .entity("{\"msg\":\"UNAUTHORIZED\"}")
                .build());
    }

    private boolean allowToCreateAccount(String path, String method) {
        return path.equals("accounts") && method.equals("POST");
    }

    private boolean allowRoot(String path) {
        return path.equals("");
    }

    private boolean allowOptions(String method) {
        System.out.println(method.equals("OPTIONS"));
        return method.equals("OPTIONS");
    }
}
