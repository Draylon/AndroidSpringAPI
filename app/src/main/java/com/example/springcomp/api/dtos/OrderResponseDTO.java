package com.example.springcomp.api.dtos;

import com.example.springcomp.enums.OrderStatusEnum;

import java.util.List;

public class OrderResponseDTO {
    private Integer orderId;
    private Double totalValue;
    private OrderStatusEnum orderStatus;
    private UserResponseDTO userResponse;
    private RestaurantResponseDTO restaurantResponse;
    private List<OrderItemDTO> items;


    public Integer getOrderId() {
        return orderId;
    }

    public OrderResponseDTO setOrderId(Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public OrderResponseDTO setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public OrderResponseDTO setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public UserResponseDTO getUserResponse() {
        return userResponse;
    }

    public OrderResponseDTO setUserResponse(UserResponseDTO userResponse) {
        this.userResponse = userResponse;
        return this;
    }

    public RestaurantResponseDTO getRestaurantResponse() {
        return restaurantResponse;
    }

    public OrderResponseDTO setRestaurantResponse(RestaurantResponseDTO restaurantResponse) {
        this.restaurantResponse = restaurantResponse;
        return this;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public OrderResponseDTO setItems(List<OrderItemDTO> items) {
        this.items = items;
        return this;
    }
}
