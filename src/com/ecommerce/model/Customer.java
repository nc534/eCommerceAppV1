package com.ecommerce.model;

public class Customer {
    private String user_id;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;

    public Customer(){

    }

    public Customer(String user_id, String password, String name, String email, String phone, String address) {
        this.user_id = user_id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getUserId() {
        return user_id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
