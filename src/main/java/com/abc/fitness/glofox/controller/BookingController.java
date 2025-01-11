package com.abc.fitness.glofox.controller;

import com.abc.fitness.glofox.dto.BookingRequest;
import com.abc.fitness.glofox.entity.BookingEntity;
import com.abc.fitness.glofox.exception.BookingException;
import com.abc.fitness.glofox.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;


    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingEntity> bookClass(@Valid @RequestBody BookingRequest bookingRequest) throws BookingException {
        return ResponseEntity.ok(bookingService.bookClass(bookingRequest));
    }

    @GetMapping
    public ResponseEntity<List<BookingEntity>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

}
