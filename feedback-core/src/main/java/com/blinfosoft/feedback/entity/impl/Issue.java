/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.entity.impl;

import com.blinfosoft.feedback.entity.DefaultApp;
import com.blinfosoft.feedback.entity.DefaultUser;
import com.blinfosoft.feedback.entity.DomainEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.PrePersist;

/**
 *
 * @author js
 */
public interface Issue extends DomainEntity<Long>, Serializable {

    public DefaultUser getUser();

    public void setUser(DefaultUser user);

    public void setId(int id) ;

    public String getTitle();

    public void setTitle(String title);

    public String getType();

    public void setType(String type);

    public Date getCreatedOn();

    @PrePersist
    public void setCreatedOn();

    public String getMsg();

    public void setMsg(String msg);

    public DefaultApp getApp();

    public void setApp(DefaultApp app);
}
