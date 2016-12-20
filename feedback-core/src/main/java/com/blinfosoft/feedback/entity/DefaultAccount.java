/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.entity;

import com.blinfosoft.feedback.entity.impl.Account;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author js
 */
@Entity
@Table(name = "Account")
public class DefaultAccount implements Account {

    @Id
    @Column(name = "Account_Id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String license;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<DefaultApp> app = new LinkedHashSet<DefaultApp>();

    @Override
    public String getAccountName() {
        return this.name;
    }

    @Override
    public String setAccountName(String name) {
        return this.name = name;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String setEmail(String email) {
        return this.email = email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String setPassword(String password) {
        return this.password = password;
    }

    @Override
    public String getLicense() {
        return this.license;
    }

    @Override
    public String setLicense(String license) {
        return this.license = license;
    }

    @Override
    public Collection<DefaultApp> getApp() {
        return this.app;
    }

    @Override
    public void setApp(Collection<DefaultApp> app) {
        this.app = app;
    }
}
