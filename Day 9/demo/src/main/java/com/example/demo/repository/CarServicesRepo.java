package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CarServices;

public interface CarServicesRepo extends JpaRepository<CarServices,Integer> {
    
}