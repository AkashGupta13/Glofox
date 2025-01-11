package com.abc.fitness.glofox.service;

import com.abc.fitness.glofox.dto.ClassRequest;
import com.abc.fitness.glofox.entity.ClassEntity;
import com.abc.fitness.glofox.repository.ClassRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

    private final ClassRepository classRepository;

    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public ClassEntity createClass(ClassRequest classRequest) {
        ClassEntity classEntity = ClassEntity.builder()
                .name(classRequest.getName())
                .startDate(classRequest.getStartDate())
                .endDate(classRequest.getEndDate())
                .capacity(classRequest.getCapacity())
                .build();
        return classRepository.save(classEntity);
    }

    public List<ClassEntity> getAllClasses() {
        return classRepository.findAll();
    }

    public Optional<ClassEntity> findClassForDate(LocalDate classDate) {
        return classRepository.findFirstByStartDateLessThanEqualAndEndDateGreaterThanEqual(classDate, classDate);
    }
}
