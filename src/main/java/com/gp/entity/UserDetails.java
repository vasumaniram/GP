/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author gbs02362
 */
@Entity
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String telco;
    private String userHandle;
    private String token;

    protected UserDetails() {
    }

    public UserDetails(final String telco, final String userHandle, final String token) {
        this.telco = telco;
        this.userHandle = userHandle;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public String getTelco() {
        return telco;
    }

    public String getUserHandle() {
        return userHandle;
    }

    public String getToken() {
        return token;
    }
    
    public void setToken(final String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserDetails{" + "id=" + id + ", telco=" + telco + ", userHandle=" + userHandle + ", token=" + token + '}';
    }

}
