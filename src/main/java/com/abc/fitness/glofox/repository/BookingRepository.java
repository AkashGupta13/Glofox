package com.abc.fitness.glofox.repository;

import com.abc.fitness.glofox.entity.BookingEntity;
import com.abc.fitness.glofox.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

    

}
