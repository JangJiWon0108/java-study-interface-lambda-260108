package com.jjw.study.controller;

import com.jjw.study.service.SortService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/jiwon/sort")
@Slf4j
public class SortController {
    private final SortService sortService;

    // sortUsingFor
    // sortUsingQuickSort
    // sortUsingDualPivotQuickSort
    // sortUsingTimSort
    // sortUsingListSortComparator
    // sortUsingListSortLambda

    // SortController 생성 시 수행
    // 특정 정렬 서비스 구현체를 주입
    public SortController (@Qualifier("sortUsingFor") SortService sortService) {
        this.sortService = sortService;
    }

    @PostMapping("/exec")
    public List<Map<Integer, Integer>> execSort(@RequestBody Map<String, Object> inputParamMap) {
        return sortService.execSort(inputParamMap.get("sort_target").toString(), inputParamMap.get("sort_order").toString());
    }
}
