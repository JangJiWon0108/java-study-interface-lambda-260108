package com.jjw.study.controller;

import com.jjw.study.classStudy.AnimalUse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/jiwon/classStudy")
public class ClassStudyController {

    private final AnimalUse animalUse;

    @GetMapping("")
    public Map<String, Object> classStudy() {
        return animalUse.animalUseTest();
    }
}
