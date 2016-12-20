/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.mysql;

/**
 *
 * @author js
 */
public class MysqlException extends RuntimeException{

    public MysqlException(String message, Throwable cause) {
        super(message, cause);
    }

}
