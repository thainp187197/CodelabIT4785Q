package com.thainp20187197.codelabit4785q.model;

import java.io.Serializable;

public class User implements Serializable {
    private final int id;
    private final String name;
    private final String username;
    private final String email;
    private final Avatar avatar;
    private final Address address;
    private final String phone;
    private final String website;
    private final Company company;

    public User(int id, String name, String username, String email, Avatar avatar, Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.avatar = avatar;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Company getCompany() {
        return company;
    }
}
