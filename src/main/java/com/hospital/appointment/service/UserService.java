package com.hospital.appointment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.appointment.entity.User;
import com.hospital.appointment.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userrepository;
    //create
    public User createUser(User user){
        return userrepository.save(user);
    }
    //getall
    public List<User> getAllUser(){
        return userrepository.findAll();
    }
    //getbyid
    public User getUserById(Long userId){
        return userrepository.findById(userId).orElse(null);
    }
    //update
    public User updateUser(Long userId, User user){
        Optional<User> op=userrepository.findById(userId);
        if(op.isPresent()){
            User gettingUser=op.get();
            gettingUser.setFirstName(user.getFirstName());
            gettingUser.setLastName(user.getLastName());
            gettingUser.setPhoneNumber(user.getPhoneNumber());
            gettingUser.setDateOfBirth(user.getDateOfBirth());
            gettingUser.setEmail(user.getEmail());
            gettingUser.setGender(user.getGender());
            return userrepository.save(gettingUser);
        }
        return null;
    }
    //delete
    public void deleteUser(Long userId){
        Optional<User> op=userrepository.findById(userId);
        if(op.isPresent()){
            userrepository.deleteById(userId);
        }
    }

}
