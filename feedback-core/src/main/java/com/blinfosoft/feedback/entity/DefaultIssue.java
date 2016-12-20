/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.entity;

import com.blinfosoft.feedback.entity.impl.Issue;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author js
 */
@Entity
@Table(name = "issue")
public class DefaultIssue implements Issue {

   @Id
    @Column(name = "Issue_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String type;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    private String msg;
    @ManyToOne
    @JoinColumn(name = "App_Id", nullable = false)
    private DefaultApp app;
    @ManyToOne
    @JoinColumn(name = "User_Id", nullable = false)
    private DefaultUser user;

    @Override
    public DefaultUser getUser() {
        return user;
    }

    @Override
    public void setUser(DefaultUser user) {
        this.user = user;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Date getCreatedOn() {
        return createdOn;
    }

    @Override
    @PrePersist
    public void setCreatedOn() {
        this.createdOn = new Date();
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public DefaultApp getApp() {
        return app;
    }

    @Override
    public void setApp(DefaultApp app) {
        this.app = app;
    }

    @Override
    public Long getId() {
        return this.id;
    }
}
