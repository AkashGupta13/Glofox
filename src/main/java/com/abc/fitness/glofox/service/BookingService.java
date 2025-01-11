package com.abc.fitness.glofox.service;

import com.abc.fitness.glofox.dto.BookingRequest;
import com.abc.fitness.glofox.entity.BookingEntity;
import com.abc.fitness.glofox.entity.ClassEntity;
import com.abc.fitness.glofox.exception.BookingException;
import com.abc.fitness.glofox.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final ClassService classService;
    private final BookingRepository bookingRepository;

    public BookingService(ClassService classService, BookingRepository bookingRepository) {
        this.classService = classService;
        this.bookingRepository = bookingRepository;
    }

    public BookingEntity bookClass(BookingRequest bookingRequest) throws BookingException {
        Optional<ClassEntity> allotedClass = classService.findClassForDate(bookingRequest.getClassDate());
        if(allotedClass.isEmpty()) {
            throw new BookingException("No class found for given date");
        }
        BookingEntity booking = BookingEntity.builder()
                .classAlloted(allotedClass.get())
                .classDate(bookingRequest.getClassDate())
                .name(bookingRequest.getName())
                .build();
        return bookingRepository.save(booking);
    }

    public List<BookingEntity> getAllBookings() {
        return bookingRepository.findAll();
    }
}
