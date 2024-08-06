package com.example.demo.controller;

import com.example.demo.model.BookingDetails;
import com.example.demo.service.BookingDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingDetailsController {

    @Autowired
    private BookingDetailsService bookingDetailsService;

    @PostMapping
    public ResponseEntity<BookingDetails> addBooking(@RequestBody BookingDetails bookingDetails) {
        BookingDetails createdBooking = bookingDetailsService.addBooking(bookingDetails);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookingDetails>> getAllBookings() {
        List<BookingDetails> bookings = bookingDetailsService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDetails> getBookingById(@PathVariable Long id) {
        Optional<BookingDetails> booking = bookingDetailsService.getBookingById(id);
        return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingDetails> updateBooking(@PathVariable Long id, @RequestBody BookingDetails bookingDetails) {
        BookingDetails updatedBooking = bookingDetailsService.updateBooking(id, bookingDetails);
        return updatedBooking != null ? ResponseEntity.ok(updatedBooking) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingDetailsService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}