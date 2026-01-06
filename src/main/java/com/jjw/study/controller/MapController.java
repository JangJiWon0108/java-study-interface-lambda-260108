package com.jjw.study.controller;

import com.jjw.study.service.MapService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/jiwon/map")
@RequiredArgsConstructor
@Slf4j
public class MapController {

    private final MapService mapService;

    @GetMapping("")
    public void mapStudy() {
        mapService.mapStudy();
    }
}
