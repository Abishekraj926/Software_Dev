package com.example.demo.service;


import com.example.demo.model.BookingDetails;
import com.example.demo.repository.BookingDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingDetailsService {

    @Autowired
    private BookingDetailsRepo bookingDetailsRepository;

    public BookingDetails addBooking(BookingDetails bookingDetails) {
        bookingDetails.setBookingDate(LocalDateTime.now());
        return bookingDetailsRepository.save(bookingDetails);
    }

    public List<BookingDetails> getAllBookings() {
        return bookingDetailsRepository.findAll();
    }

    public Optional<BookingDetails> getBookingById(Long id) {
        return bookingDetailsRepository.findById(id);
    }

    public BookingDetails updateBooking(Long id, BookingDetails bookingDetails) {
        if (bookingDetailsRepository.existsById(id)) {
            bookingDetails.setId(id);
            return bookingDetailsRepository.save(bookingDetails);
        }
        return null;
    }

    public void deleteBooking(Long id) {
        bookingDetailsRepository.deleteById(id);
    }
}