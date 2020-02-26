package com.example.springcomp.services;

import com.example.springcomp.api.dtos.CreateOrderItemDTO;
import com.example.springcomp.api.dtos.OrderItemDTO;
import com.example.springcomp.entities.Order;
import com.example.springcomp.entities.OrderItem;
import com.example.springcomp.exceptions.NotFoundException;

import java.util.List;

public class OrderItemService {

    public List<OrderItem> createOrderItemList(List<CreateOrderItemDTO> items, Order order){
        return null;
    }

    public List<OrderItemDTO> buildOrderItemDTOs(List<OrderItem> list){
        return null;
    }

    private OrderItem buildOrderItem(CreateOrderItemDTO createOrderItemDTO, Order order){
        return null;
    }


    public OrderItem findById(Integer id){
        return null;
    }

    public OrderItemDTO getById(Integer id){
        return null;
    }
}
