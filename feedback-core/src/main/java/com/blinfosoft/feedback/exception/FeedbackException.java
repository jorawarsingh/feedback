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
public class FeedbackException extends RuntimeException{
    private String causeMsg;

    public FeedbackException(String errorMsg, Exception e) {
        super(errorMsg, e);
    }

    public String getCauseMsg() {
        return causeMsg;
    }
}
