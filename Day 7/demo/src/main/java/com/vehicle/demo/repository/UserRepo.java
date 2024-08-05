package com.vehicle.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicle.demo.model.User;

public interface UserRepo extends JpaRepository <User,Integer>{

    
} 