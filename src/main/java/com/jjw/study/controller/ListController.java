package com.jjw.study.controller;

import com.jjw.study.service.ListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jiwon/list")
@Slf4j
public class ListController {

    private final ListService listService;

    @GetMapping("")
    public void listStudy() {
        listService.listStudy();
    }
}
