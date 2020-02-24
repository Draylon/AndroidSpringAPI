package com.example.springcomp.api.dtos;

import java.util.List;

public class CreateOrderDTO {

    private Integer userId;

    private List<CreateOrderItemDTO> itemList;

    private Integer restaurantId;


    public Integer getUserId() {
        return userId;
    }

    public CreateOrderDTO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public List<CreateOrderItemDTO> getItemList() {
        return itemList;
    }

    public CreateOrderDTO setItemList(List<CreateOrderItemDTO> itemList) {
        this.itemList = itemList;
        return this;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public CreateOrderDTO setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }
}
