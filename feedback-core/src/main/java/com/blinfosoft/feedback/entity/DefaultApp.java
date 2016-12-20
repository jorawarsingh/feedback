/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.entity;

import com.blinfosoft.feedback.entity.impl.Account;
import com.blinfosoft.feedback.entity.impl.App;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author js
 */
@Entity
@Table(name = "App")
public class DefaultApp implements App {

   @Id
    @Column(name = "App_Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "app", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Collection<DefaultIssue> issue;
    @ManyToOne
    @JoinColumn(name = "Account_Id", nullable = false)
    private DefaultAccount account;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Collection<DefaultIssue> getIssue() {
        return issue;
    }

    @Override
    public void setIssue(Set<DefaultIssue> issue) {
        this.issue = issue;
    }

    @Override
    public DefaultAccount getAccount() {
        return account;
    }

    @Override
    public void setAccount(DefaultAccount account) {
        this.account = account;
    }

    @Override
    public Long getId() {
        return this.id;
    }
}
