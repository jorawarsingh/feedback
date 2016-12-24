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
public class AppAlreadyExistExceptions extends Exception{

    public AppAlreadyExistExceptions(String message) {
        super(message);
    }

    public AppAlreadyExistExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public AppAlreadyExistExceptions(Throwable cause) {
        super(cause);
    }
    
}
