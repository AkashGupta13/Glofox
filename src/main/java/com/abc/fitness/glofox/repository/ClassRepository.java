package com.abc.fitness.glofox.repository;

import com.abc.fitness.glofox.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {

    Optional<ClassEntity> findFirstByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate startDate, LocalDate endDate);

}
