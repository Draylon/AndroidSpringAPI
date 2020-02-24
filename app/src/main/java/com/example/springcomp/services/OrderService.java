package com.example.springcomp.services;

import com.example.springcomp.api.dtos.CreateOrderDTO;
import com.example.springcomp.api.dtos.CreateOrderItemDTO;
import com.example.springcomp.api.dtos.OrderResponseDTO;
import com.example.springcomp.api.dtos.UpdateOrderDTO;
import com.example.springcomp.entities.Order;
import com.example.springcomp.enums.OrderStatusEnum;

import java.util.List;

public class OrderService {

    public RestaurantService restaurantService;
    public UserService userService;
    ProductService productService;
    OrderItemService orderItemService;

    public OrderResponseDTO create(CreateOrderDTO createOrderDTO){
        return null;
    }

    public Order createOrder(CreateOrderDTO createOrderDTO){
        return null;
    }

    public Double calculateOrderTotalValue(List<CreateOrderItemDTO> items){
        return null;
    }

    public OrderResponseDTO setResponseDTO(Order order){
        return null;
    }

    public OrderResponseDTO getById(Integer id){
        return null;
    }

    public Order findById(Integer id){
        return null;
    }

    public List<OrderResponseDTO> getAll(){
        return null;
    }

    public void updateOrder(UpdateOrderDTO updateOrderDTO) {

    }

    public void updateOrderStatus(Integer id, OrderStatusEnum orderStatusEnum) {

    }

}