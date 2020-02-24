package com.example.springcomp.api.dtos;

public class CreateProductDTO {

    private String name;

    private Double value;

    private Integer restaurantId;

    private Boolean isValid;


    public String getName() {
        return name;
    }

    public CreateProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public CreateProductDTO setValue(Double value) {
        this.value = value;
        return this;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public CreateProductDTO setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }

    public Boolean getValid() {
        return isValid;
    }

    public CreateProductDTO setValid(Boolean valid) {
        isValid = valid;
        return this;
    }
}
