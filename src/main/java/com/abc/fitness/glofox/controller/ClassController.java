package com.abc.fitness.glofox.controller;

import com.abc.fitness.glofox.dto.ClassRequest;
import com.abc.fitness.glofox.entity.ClassEntity;
import com.abc.fitness.glofox.service.ClassService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/classes")
@Slf4j
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping
    public ResponseEntity<ClassEntity> createClass(@Valid @RequestBody ClassRequest classRequest) {
        return ResponseEntity.ok(classService.createClass(classRequest));
    }

    @GetMapping
    public ResponseEntity<List<ClassEntity>> getClasses() {
        return ResponseEntity.ok(classService.getAllClasses());
    }


}
