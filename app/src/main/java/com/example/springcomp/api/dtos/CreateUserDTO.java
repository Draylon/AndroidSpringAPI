package com.example.springcomp.api.dtos;

public class CreateUserDTO {
    private String name;
    private String phone;
    private String email;
    private String pword;
    private String address;

    public String getName() {
        return name;
    }

    public CreateUserDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CreateUserDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateUserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPword() {
        return pword;
    }

    public CreateUserDTO setPword(String pword) {
        this.pword = pword;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CreateUserDTO setAddress(String address) {
        this.address = address;
        return this;
    }
}
