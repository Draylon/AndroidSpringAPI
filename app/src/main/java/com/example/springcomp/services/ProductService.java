package com.example.springcomp.services;

import com.example.springcomp.api.dtos.CreateProductDTO;
import com.example.springcomp.api.dtos.ProductResponseDTO;
import com.example.springcomp.api.dtos.RestaurantResponseDTO;
import com.example.springcomp.api.dtos.UpdateProductDTO;
import com.example.springcomp.entities.Product;
import com.example.springcomp.entities.Restaurant;

import java.util.List;

public class ProductService {

    RestaurantService restaurantService;

    public ProductResponseDTO createProduct(CreateProductDTO createProductDTO){
        return null;
    }

    public ProductResponseDTO getById(Integer id){
        return null;
    }

    public Product findById(Integer id){
        return null;
    }

    public List<ProductResponseDTO> getAll(){
        return null;
    }

    public void deleteById(Integer id) {

    }

    public void deleteAll(){

    }

    public void updateProduct(UpdateProductDTO updateProductDTO) {

    }

    public void invalidateProduct(Integer id) {

    }
}
