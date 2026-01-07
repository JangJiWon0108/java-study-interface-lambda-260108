package com.jjw.study.service.impl;

import com.jjw.study.service.SortService;
import com.jjw.study.util.RandomListUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("sortUsingListSortLambda")
@RequiredArgsConstructor
@Slf4j
public class SortUsingListSortLambdaServiceImpl implements SortService {

    private final RandomListUtil randomListUtil;
    /**
     * ListSortLambda 이용한 정렬
     * @param sortTarget (KEY or VALUE)
     * @param sortOrder (ASC or DESC)
     * @return
     */
    public List<Map<Integer, Integer>> execSort(String sortTarget, String sortOrder) {
        try {
            log.info("RUN sortUsingListSortLambda");
            return sortUsingListSortLambda(sortTarget, sortOrder);
        } catch (Exception e) {
            log.error("SortUsingTimSortServiceImpl 에러 : {}", e.getMessage());
            throw e;
        }
    }

    public List<Map<Integer, Integer>> sortUsingListSortLambda(String sortTarget, String sortOrder) {


        return List.of(Map.of());
    }
}
