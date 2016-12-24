/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.exception.mapper;

import com.blinfosoft.feedback.dto.out.AccountErrorDTO;
import com.blinfosoft.feedback.exception.EmailAlreadyExistException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author js
 */
@Provider
public class EmailAlreadyExistExceptionMapper implements ExceptionMapper<EmailAlreadyExistException>{

    @Override
    public Response toResponse(EmailAlreadyExistException exception) {
        AccountErrorDTO err = new AccountErrorDTO("Email Already Exist", exception.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(err).build();
    }

}
