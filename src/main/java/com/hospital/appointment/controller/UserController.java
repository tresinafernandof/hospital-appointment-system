package com.hospital.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.appointment.entity.User;
import com.hospital.appointment.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userservice;
    //callcreate
    @PostMapping
    public User callCreateUser(@RequestBody User user){
        return userservice.createUser(user);
    }
    //call get all
    @GetMapping
    public List<User> callGetAll(){
        return userservice.getAllUser();
    }
    //call get by id
    @GetMapping("/{userId}")
    public User callGetById(@PathVariable Long userId){
        return userservice.getUserById(userId);
    }
    //call update
    @PutMapping("/{userId}")
    public User callUpdateUser(@PathVariable Long userId, @RequestBody User user){
        return userservice.updateUser(userId, user);
    }
    //call delete
    @DeleteMapping("/{userId}")
    public void callDeleteUser(@PathVariable Long userId){
        userservice.deleteUser(userId);
    }
}
