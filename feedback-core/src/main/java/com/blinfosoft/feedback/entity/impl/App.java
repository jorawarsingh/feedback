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
public interface App extends DomainEntity<Long>, Serializable{

    public String getName();

    public void setName(String name);

    public Collection<DefaultIssue> getIssue();

    public void setIssue(Set<DefaultIssue> issue);

    public DefaultAccount getAccount();

    public void setAccount(DefaultAccount account);
}
