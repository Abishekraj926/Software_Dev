package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    //user signup functionality
    public User signup(User user)
    {
        return userRepo.save(user);
    }

    //user profile update functionality
    public User getByEmail(String email)
    {
        return userRepo.findById(email).orElse(null);
    }
    public Boolean updateProfile(String email,User user)
    {
        if(this.getByEmail(email)==null)
        {
            return false;
        }
        try
        {
            userRepo.save(user);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    //user delete account functionality
    public Boolean deleteAccount(String email)
    {
        if(this.getByEmail(email)== null)
        {
            return false;
        }
        userRepo.deleteById(email);
        return true;
    }
}