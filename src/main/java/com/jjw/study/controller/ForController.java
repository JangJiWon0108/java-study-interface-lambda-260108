package com.jjw.study.controller;

import com.jjw.study.service.ForService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("jiwon/for")
@RequiredArgsConstructor
@Slf4j
public class ForController {

    private final ForService forService;

    @GetMapping("")
    public void forStudy() {
        forService.forStudy();
    }
}
