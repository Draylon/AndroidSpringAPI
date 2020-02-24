package com.example.springcomp.api.dtos;

public class ProductResponseDTO {
    private Integer productId;
    private String name;
    private Double value;
    private RestaurantResponseDTO restaurant;
    private Boolean isValid;

    public Integer getProductId() {
        return productId;
    }

    public ProductResponseDTO setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public ProductResponseDTO setValue(Double value) {
        this.value = value;
        return this;
    }

    public RestaurantResponseDTO getRestaurant() {
        return restaurant;
    }

    public ProductResponseDTO setRestaurant(RestaurantResponseDTO restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public Boolean getValid() {
        return isValid;
    }

    public ProductResponseDTO setValid(Boolean valid) {
        isValid = valid;
        return this;
    }
}

