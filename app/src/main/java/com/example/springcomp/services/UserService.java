package com.example.springcomp.services;

import com.example.springcomp.api.dtos.CreateUserDTO;
import com.example.springcomp.api.dtos.UserResponseDTO;
import com.example.springcomp.api.mappers.UserMapper;
import com.example.springcomp.entities.User;
import com.example.springcomp.exceptions.AlreadyExistsException;
import com.example.springcomp.exceptions.NotFoundException;

import java.util.List;

public class UserService {
    public UserResponseDTO create(CreateUserDTO createUserDTO){
        return null;
    }

    private void validateUserEmail(String email){

    }

    private User createUser(CreateUserDTO createUserDTO){ // not being used
        return null;
    }
    private User saveUser(User user){
        return null;
    }

    public UserResponseDTO getById(Integer id){
        return null;
    }

    public User findById(Integer id){
        return null;
    }

    public List<UserResponseDTO> listAll(){
        return null;
    }

}
