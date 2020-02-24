package com.example.springcomp.entities;

public class Restaurant {
    private Integer id;
    private String name;
    private String cnpj;
    private String phone;
    private String email;


    public Integer getId() {
        return id;
    }

    public Restaurant setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Restaurant setName(String name) {
        this.name = name;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Restaurant setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Restaurant setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Restaurant setEmail(String email) {
        this.email = email;
        return this;
    }
}
