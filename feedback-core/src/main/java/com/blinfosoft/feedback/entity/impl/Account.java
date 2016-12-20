/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.entity.impl;

import com.blinfosoft.feedback.entity.DefaultApp;
import com.blinfosoft.feedback.entity.DomainEntity;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author js
 */
public interface Account extends DomainEntity<Long>, Serializable {

    public String getAccountName();

    public String setAccountName(String name);

    public String getEmail();

    public String setEmail(String email);

    public String getPassword();

    public String setPassword(String password);

    public String getLicense();

    public String setLicense(String license);

    public Collection<DefaultApp> getApp();

    public void setApp(Collection<DefaultApp> app);
}
