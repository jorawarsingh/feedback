/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.exception.mapper;

import com.blinfosoft.feedback.dto.out.AccountErrorDTO;
import com.blinfosoft.feedback.exception.InValidCredantialsExcetions;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author js
 */
@Provider
public class InValidCredantialsExceptionsMapper implements ExceptionMapper<InValidCredantialsExcetions>{

    @Override
    public Response toResponse(InValidCredantialsExcetions exception) {
        AccountErrorDTO err = new AccountErrorDTO("invalid credantials", exception.getMessage());
        return Response.status(Response.Status.UNAUTHORIZED).entity(err).build();
    }
    
}
