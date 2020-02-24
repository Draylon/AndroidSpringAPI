package com.example.springcomp.api.dtos;

public class UpdateProductDTO {
    private Integer id;
    private String name;
    private Double value;
    private Integer restaurantId;
    private Boolean isValid;

    public Integer getId() {
        return id;
    }

    public UpdateProductDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UpdateProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public UpdateProductDTO setValue(Double value) {
        this.value = value;
        return this;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public UpdateProductDTO setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }

    public Boolean getValid() {
        return isValid;
    }

    public UpdateProductDTO setValid(Boolean valid) {
        isValid = valid;
        return this;
    }
}
