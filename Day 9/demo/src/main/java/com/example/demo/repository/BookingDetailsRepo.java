package com.example.demo.repository;

import com.example.demo.model.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
@Repository
public interface BookingDetailsRepo extends JpaRepository<BookingDetails, Long> {
    
}