package com.jjw.study.service.impl;

import com.jjw.study.service.SortService;
import com.jjw.study.util.RandomListUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("sortUsingFor")
@RequiredArgsConstructor
@Slf4j
public class SortUsingForServiceImpl implements SortService {

    private final RandomListUtil randomListUtil;

    /**
     * for 이용한 정렬
     * @param sortTarget (KEY or VALUE)
     * @param sortOrder (ASC or DESC)
     * @return
     */
    @Override
    public List<Map<Integer, Integer>> execSort(String sortTarget, String sortOrder) {
        try {
            log.info("RUN sortUsingFor");
            return sortUsingFor(sortTarget, sortOrder);
        } catch (Exception e) {
            log.error("SortUsingForServiceImpl 에러 : {}", e.getMessage());
            throw e;
        }
    }

    public List<Map<Integer, Integer>> sortUsingFor(String sortTarget, String sortOrder) {

        List<Map<Integer, Integer>> resultList = randomListUtil.generateRandomList(1, 100, 100);

        for (int i = 0; i < resultList.size() - 1; i = i + 1) {
            for (int j = 0; j < resultList.size() - 1 - j; j = j + 1) {
                // 현재 Map, 다음 Map 추출
                Map<Integer, Integer> currentMap = resultList.get(j);
                Map<Integer, Integer> nextMap = resultList.get(j + 1);
                Integer currentTarget;
                Integer nextTarget;

                // sortTarget 에 따라 key, value 추출
                if (sortTarget.equals("KEY")) {
                    currentTarget = currentMap.entrySet().iterator().next().getKey();
                    nextTarget = nextMap.entrySet().iterator().next().getKey();
                } else {
                    currentTarget = currentMap.entrySet().iterator().next().getValue();
                    nextTarget = nextMap.entrySet().iterator().next().getValue();
                }

                // sortOrder 에 따라 비교 및 교체
                if (sortOrder.equals("ASC")) {
                    if (currentTarget > nextTarget) {
                        resultList.set(j, nextMap);
                        resultList.set(j + 1, currentMap);
                    }
                } else {
                    if (currentTarget < nextTarget) {
                        resultList.set(j, nextMap);
                        resultList.set(j + 1, currentMap);
                    }
                }


            }
        }

        return resultList;
    }
}
