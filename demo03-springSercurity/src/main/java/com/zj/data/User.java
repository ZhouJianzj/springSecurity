package com.zj.data;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2022-03-04 16:17:49
 */
public class User implements Serializable {
    private static final long serialVersionUID = -20384523162772504L;
    
    private Integer id;
    
    private String login;
    
    private String password;
    
    private String role;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString(){
        return id+ "==>"  + login + "==>"  +  password + "==>"  + role;
    }

}