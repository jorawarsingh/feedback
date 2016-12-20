/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blinfosoft.feedback.entity;

import com.blinfosoft.feedback.entity.impl.User;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author js
 */
@Entity
@Table(name = "User")
public class DefaultUser implements User {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id", nullable = false)
    private long id;
    @Column(nullable = false, unique = true)
    private String userName;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<DefaultIssue> issue = new LinkedHashSet<DefaultIssue>();

    @Override
    public Collection<DefaultIssue> getIssue() {
        return issue;
    }

    @Override
    public void setIssue(Set<DefaultIssue> issue) {
        this.issue = issue;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Long getId() {
         return this.id;
    }

}
