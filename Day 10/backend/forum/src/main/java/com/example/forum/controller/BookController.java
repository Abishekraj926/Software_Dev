package com.example.forum.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.forum.model.Booking;
import com.example.forum.service.BookingService;

@RestController
@RequestMapping("/resource")
public class BookController {

    @Autowired
    BookingService bookingService;
    
    @PostMapping("/upload")
    public ResponseEntity<Booking> upload(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        Booking newBooking = new Booking();
        newBooking.setType(file.getContentType());
        
        // Additional processing of the file can be done here
        
        Booking uploadedBooking = bookingService.create(newBooking);
        return new ResponseEntity<>(uploadedBooking, HttpStatus.CREATED);
    }
    
    @GetMapping("/getdetails")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{bookingId}")
    public ResponseEntity<Boolean> delete(@PathVariable("bookingId") int id) {
        boolean isDeleted = bookingService.deleteBooking(id);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
