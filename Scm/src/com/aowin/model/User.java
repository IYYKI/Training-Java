package com.aowin.model;

import java.util.List;

public class User {
    private String account;
    private String password;
    private String name;
    private String createDate;
    private String status;
    @SuppressWarnings("unchecked")
    private List authorityList;

    public User() {

    }

    public User(String account, String password, String name,
                String createDate, String status) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.createDate = createDate;
        this.status = status;

    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @SuppressWarnings("unchecked")
    public List getAuthorityList() {
        return authorityList;
    }

    @SuppressWarnings("unchecked")
    public void setAuthorityList(List authorityList) {
        this.authorityList = authorityList;
    }


}
