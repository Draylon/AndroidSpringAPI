package com.example.springcomp.entities;


import com.example.springcomp.enums.OrderStatusEnum;

import java.util.List;

public class Order {
    private Integer id;
    private Double totalValue;
    private OrderStatusEnum status;
    private Restaurant restaurant;
    private User user;
    private List<OrderItem> items;


    public Integer getId() {
        return id;
    }

    public Order setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public Order setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public Order setStatus(OrderStatusEnum status) {
        this.status = status;
        return this;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Order setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Order setItems(List<OrderItem> items) {
        this.items = items;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", totalValue=" + totalValue +
                ", status=" + status +
                ", restaurant=" + restaurant +
                ", user=" + user +
                ", items=" + items +
                '}';
    }
}
