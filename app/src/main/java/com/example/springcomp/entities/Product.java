package com.example.springcomp.entities;

public class Product {
    private Integer id;
    private String name;
    private Double value;
    private Restaurant restaurant;
    private Boolean isValid;


    public Integer getId() {
        return id;
    }

    public Product setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public Product setValue(Double value) {
        this.value = value;
        return this;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Product setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public Boolean getValid() {
        return isValid;
    }

    public Product setValid(Boolean valid) {
        isValid = valid;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", restaurant=" + restaurant +
                ", isValid=" + isValid +
                '}';
    }
}
