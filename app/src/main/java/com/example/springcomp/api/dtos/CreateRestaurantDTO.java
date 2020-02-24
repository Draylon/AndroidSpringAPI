package com.example.springcomp.api.dtos;

public class CreateRestaurantDTO {


    private String name;
    private String email;
    private String cnpj;
    private String phone;

    public String getName() {
        return name;
    }

    public CreateRestaurantDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateRestaurantDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public CreateRestaurantDTO setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CreateRestaurantDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }


}
