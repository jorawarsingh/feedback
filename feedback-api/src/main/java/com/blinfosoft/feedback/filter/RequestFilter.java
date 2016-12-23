/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.filter;

import com.blinfosoft.feedback.dao.DaoFactory;
import com.blinfosoft.feedback.dao.FeedbackEntityManagerFactory;
import com.blinfosoft.feedback.exception.AccountNotFoundException;
import com.blinfosoft.feedback.service.AccountService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;

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
        if (!"OPTIONS".equals(requestContext.getMethod())) {
            if (accountService.verfyAccount(authCredentails)) {
            } else {
                requestContext.abortWith(Response
                        .status(Response.Status.UNAUTHORIZED)
                        .entity("{\"msg\":\"UNAUTHORIZED\"}")
                        .build());
            }
        }
    }
}
