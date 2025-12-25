package com.search.engine.controller;

import com.search.engine.domain.Student;
import com.search.engine.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class EsTestController {

    private final StudentRepository studentRepository;

    //1.데이터 저장 테스트
    @PostMapping("/test/student")
    public String save(@RequestParam String name, @RequestParam String desc){
        Student student = new Student(UUID.randomUUID().toString(), name, 20, desc);
        studentRepository.save(student);
        return "Saved::" + student.getName();
    }

    //2.검색 테스트
    @GetMapping("/test/student/{name}")
    public Object find(@PathVariable String name){
        return studentRepository.findByName(name);
    }
}
