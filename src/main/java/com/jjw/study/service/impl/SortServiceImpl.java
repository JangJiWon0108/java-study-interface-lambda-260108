package com.jjw.study.service.impl;

import com.jjw.study.service.SortService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class SortServiceImpl implements SortService {

    /**
     * for 이용한 정렬
     * @param sortTarget (KEY or VALUE)
     * @param sortOrder (ASC or DESC)
     * @return
     */
    public List<Map<Integer, Integer>> sortUsingFor(String sortTarget, String sortOrder) {

        List<Map<Integer, Integer>> resultList = generateRandomList(1, 100, 100);

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

    /**
     * dualPivotQuickSort 이용한 정렬
     * @param sortTarget (key or value)
     * @param sortOrder (asc or desc)
     * @return
     */
    public List<Map<Integer, Integer>> sortUsingDualPivotQuickSort(String sortTarget, String sortOrder) {
        return List.of(Map.of());
    }

    /**
     * timSort 이용한 정렬
     * @param sortTarget (key or value)
     * @param sortOrder (asc or desc)
     * @return
     */
    public List<Map<Integer, Integer>> sortUsingTimSort(String sortTarget, String sortOrder) {
        return List.of(Map.of());
    }

    /**
     * listSortComparator 이용한 정렬
     * @param sortTarget (key or value)
     * @param sortOrder (asc or desc)
     * @return
     */
    public List<Map<Integer, Integer>> sortUsingListSortComparator(String sortTarget, String sortOrder) {
        return List.of(Map.of());
    }

    /**
     * listSortLambda 이용한 정렬
     * @param sortTarget (key or value)
     * @param sortOrder (asc or desc)
     * @return
     */
    public List<Map<Integer, Integer>> sortUsingListSortLambda(String sortTarget, String sortOrder) {
        return List.of(Map.of());
    }

    /**
     * 랜덤값으로 구성된 List<Map<Integer, Integer>> 생성
     * @param minValue 최소값
     * @param maxValue 최대값
     * @param listSize 배열크기
     * @return
     */
    public List<Map<Integer, Integer>> generateRandomList(Integer minValue, Integer maxValue, Integer listSize) {
        Random rd = new Random();
        List<Map<Integer, Integer>> randomList = new ArrayList<>();

        for (int i=0; i<listSize; i=i+1) {
            randomList.add(
                Map.of(
                        rd.nextInt( (maxValue - minValue) + 1) + minValue, rd.nextInt( (maxValue - minValue) + 1) + minValue
                )
            );
        }

        return randomList;
    }
}
