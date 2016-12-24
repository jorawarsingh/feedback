/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.exception;

/**
 *
 * @author js
 */
public class UserAlreadyExistExceptions extends Exception{

    public UserAlreadyExistExceptions(String message) {
        super(message);
    }

    public UserAlreadyExistExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyExistExceptions(Throwable cause) {
        super(cause);
    }

}
