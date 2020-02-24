package com.example.springcomp.api.dtos;

public class CreateOrderItemDTO {
    private Integer productId;
    private Integer quantity;


    public Integer getProductId() {
        return productId;
    }

    public CreateOrderItemDTO setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public CreateOrderItemDTO setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
