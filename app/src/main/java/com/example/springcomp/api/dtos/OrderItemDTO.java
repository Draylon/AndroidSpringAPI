package com.example.springcomp.api.dtos;

public class OrderItemDTO {
    private Integer id;
    private Integer quantity;
    private ProductResponseDTO productResponse;

    public Integer getId() {
        return id;
    }

    public OrderItemDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderItemDTO setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public ProductResponseDTO getProductResponse() {
        return productResponse;
    }

    public OrderItemDTO setProductResponse(ProductResponseDTO productResponse) {
        this.productResponse = productResponse;
        return this;
    }
}
