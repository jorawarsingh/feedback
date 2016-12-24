/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.entity.impl;

import com.blinfosoft.feedback.entity.DefaultAccount;
import com.blinfosoft.feedback.entity.DefaultIssue;
import com.blinfosoft.feedback.entity.DomainEntity;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 *
 * @author js
 */
public interface User extends DomainEntity<Long>, Serializable {

    public Collection<DefaultIssue> getIssue();

    public void setIssue(Set<DefaultIssue> issue);

    public void setId(long id);

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getLastName();

    public void setLastName(String lastName);

    public String getEmail();

    public void setEmail(String email);

    public Account getAccount();

    public void setAccount(Account account);

}
