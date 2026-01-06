package com.jjw.study.controller;

import com.jjw.study.service.RandomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jiwon/random")
@Slf4j
public class RandomController {

    private final RandomService randomService;

    @GetMapping("")
    public void ramdomStudy() {
        randomService.randomStudy();
    }
}
