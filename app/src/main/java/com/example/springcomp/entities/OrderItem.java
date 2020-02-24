package com.example.springcomp.entities;

public class OrderItem {
    private Integer id;
    private Order order;
    private Integer quantity;
    private Product product;


    public Integer getId() {
        return id;
    }

    public OrderItem setId(Integer id) {
        this.id = id;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public OrderItem setOrder(Order order) {
        this.order = order;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderItem setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public OrderItem setProduct(Product product) {
        this.product = product;
        return this;
    }
}
