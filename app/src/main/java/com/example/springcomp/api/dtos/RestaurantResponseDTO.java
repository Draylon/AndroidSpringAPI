package com.example.springcomp.api.dtos;

public class RestaurantResponseDTO {
    private Integer id;
    private String name;
    private String email;
    private String phone;



    public Integer getId() {
        return id;
    }

    public RestaurantResponseDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RestaurantResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RestaurantResponseDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public RestaurantResponseDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
