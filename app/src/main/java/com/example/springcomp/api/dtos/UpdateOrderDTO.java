package com.example.springcomp.api.dtos;

import com.example.springcomp.enums.OrderStatusEnum;

public class UpdateOrderDTO {

    private Integer id;

    private Double totalValue;

    private OrderStatusEnum orderStatusEnum;

    private Integer userId;

    private Integer restaurantId;


    public Integer getId() {
        return id;
    }

    public UpdateOrderDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public UpdateOrderDTO setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public OrderStatusEnum getOrderStatusEnum() {
        return orderStatusEnum;
    }

    public UpdateOrderDTO setOrderStatusEnum(OrderStatusEnum orderStatusEnum) {
        this.orderStatusEnum = orderStatusEnum;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public UpdateOrderDTO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public UpdateOrderDTO setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }

}
