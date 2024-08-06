package com.example.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.forum.model.Booking;
import com.example.forum.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;
    
    public Booking create(Booking booking) {
        return bookingRepository.save(booking);
    }
    
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    
    public Booking getBookingById(int vehicleNumber) {
        return bookingRepository.findById(vehicleNumber).orElse(null);
    }
    
    public boolean deleteBooking(int vehicleNumber) {
        if (this.getBookingById(vehicleNumber) == null) {
            return false;
        }
        bookingRepository.deleteById(vehicleNumber);
        return true;
    }
}
