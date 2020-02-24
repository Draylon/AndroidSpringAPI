package com.example.springcomp.api.dtos;

public class UserResponseDTO {
    private Integer id;
    private String name;
    private String phone;
    private String email;
    private String address;

    public Integer getId() {
        return id;
    }

    public UserResponseDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserResponseDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserResponseDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserResponseDTO setAddress(String address) {
        this.address = address;
        return this;
    }
}
