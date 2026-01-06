package com.jjw.study.controller;

import com.jjw.study.service.SortService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jiwon/sort")
@Slf4j
public class SortController {
    private final SortService sortService;

    @PostMapping("/for")
    public List<Map<Integer, Integer>> sortUsingFor(@RequestBody Map<String, Object> inputParamMap) {
        return sortService.sortUsingFor(inputParamMap.get("sort_target").toString(), inputParamMap.get("sort_order").toString());
    }

    @PostMapping("/dualPivotQuickSort")
    public List<Map<Integer, Integer>> sortUsingDualPivotQuickSort(@RequestBody Map<String, Object> inputParamMap) {
        return sortService.sortUsingDualPivotQuickSort(inputParamMap.get("sort_target").toString(), inputParamMap.get("sort_order").toString());
    }

    @PostMapping("/timSort")
    public List<Map<Integer, Integer>> sortUsingTimSort(@RequestBody Map<String, Object> inputParamMap) {
        return sortService.sortUsingTimSort(inputParamMap.get("sort_target").toString(), inputParamMap.get("sort_order").toString());
    }

    @PostMapping("/listSortComparator")
    public List<Map<Integer, Integer>> sortUsingListSortComparator(@RequestBody Map<String, Object> inputParamMap) {
        return sortService.sortUsingListSortComparator(inputParamMap.get("sort_target").toString(), inputParamMap.get("sort_order").toString());
    }

    @PostMapping("/listSortLambda")
    public List<Map<Integer, Integer>> sortUsingListSortLambda(@RequestBody Map<String, Object> inputParamMap) {
        return sortService.sortUsingListSortLambda(inputParamMap.get("sort_target").toString(), inputParamMap.get("sort_order").toString());
    }
}
