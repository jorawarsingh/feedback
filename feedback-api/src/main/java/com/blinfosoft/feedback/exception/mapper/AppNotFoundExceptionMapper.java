/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.exception.mapper;

import com.blinfosoft.feedback.dto.out.AccountErrorDTO;
import com.blinfosoft.feedback.exception.AppNotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author js
 */
@Provider
public class AppNotFoundExceptionMapper implements ExceptionMapper<AppNotFoundException>{

    @Override
    public Response toResponse(AppNotFoundException exception) {
        AccountErrorDTO err = new AccountErrorDTO("App not found", exception.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(err).build();
    }
    
}
