package com.jjw.study.service.impl;

import com.jjw.study.service.SortService;
import com.jjw.study.util.RandomListUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("sortUsingListSortComparator")
@RequiredArgsConstructor
@Slf4j
public class SortUsingListSortComparatorServiceImpl implements SortService {

    private final RandomListUtil randomListUtil;
    /**
     * ListSortComparator 이용한 정렬
     * @param sortTarget (KEY or VALUE)
     * @param sortOrder (ASC or DESC)
     * @return
     */
    public List<Map<Integer, Integer>> execSort(String sortTarget, String sortOrder) {
        try {
            log.info("RUN sortUsingListSortComparator");
            return sortUsingListSortComparator(sortTarget, sortOrder);
        } catch (Exception e) {
            log.error("SortUsingTimSortServiceImpl 에러 : {}", e.getMessage());
            throw e;
        }
    }

    public List<Map<Integer, Integer>> sortUsingListSortComparator(String sortTarget, String sortOrder) {


        return List.of(Map.of());
    }
}
