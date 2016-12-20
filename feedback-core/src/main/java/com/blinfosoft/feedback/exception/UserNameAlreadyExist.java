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
public class UserNameAlreadyExist extends Exception {

    public UserNameAlreadyExist(String name) {
        super("user with name :- "+name +" not found");
    }

    public UserNameAlreadyExist(Long id) {
        super("user with id :- "+id +" not found");
    }

}
