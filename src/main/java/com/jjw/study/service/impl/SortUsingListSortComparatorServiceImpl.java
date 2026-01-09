package com.jjw.study.service.impl;

import com.jjw.study.service.SortService;
import com.jjw.study.util.RandomListUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.zip.InflaterInputStream;

@Service("sortUsingListSortComparator")
@RequiredArgsConstructor
@Slf4j
public class SortUsingListSortComparatorServiceImpl implements SortService {

    private final RandomListUtil randomListUtil;

    public List<Map<Integer, Integer>> execSort(String sortTarget, String sortOrder) {
        try {
            log.info("RUN sortUsingListSortComparator");
            return sortUsingListSortComparator(sortTarget, sortOrder);
        } catch (Exception e) {
            log.error("SortUsingListSortComparatorServiceImpl 에러 : {}", e.getMessage());
            throw e;
        }
    }

    /**
     * List의 sort 메서드(Comparator 구현)를 이용한 정렬
     * @param sortTarget (KEY or VALUE)
     * @param sortOrder (ASC or DESC)
     * @return
     */
    public List<Map<Integer, Integer>> sortUsingListSortComparator(String sortTarget, String sortOrder) {

        // 랜덤 값으로 구성된 List<Map<Integer, Integer>> 생성 (size : 100)
        List<Map<Integer,Integer>> resultList = randomListUtil.generateRandomList(1, 100, 100);

        // 정렬 기준을 가져오는 Comparator 생성
        Comparator<Map<Integer, Integer>> comp = getComparator(sortTarget, sortOrder);

        // 리스트를 생성된 Comparator로 정렬
        resultList.sort(comp);

        return resultList;
    }

    /**
     * Comparator 생성 메서드
     * @param sortTarget
     * @param sortOrder
     * @return
     */
    public static Comparator<Map<Integer, Integer>> getComparator(String sortTarget, String sortOrder) {

        // Comapartor<> 를 익명객체를 활용해 구현하고 리턴
        return new Comparator<Map<Integer, Integer>>() {

            @Override
            public int compare(Map<Integer, Integer> currentMap, Map<Integer, Integer> nextMap) {

                Integer currentTarget;
                Integer nextTarget;

                // sortTarget 기준에 따라 key 또는 value를 선택
                if (sortTarget.equals("KEY")) {
                    currentTarget = currentMap.entrySet().iterator().next().getKey();
                    nextTarget = nextMap.entrySet().iterator().next().getKey();
                } else {
                    currentTarget = currentMap.entrySet().iterator().next().getValue();
                    nextTarget = nextMap.entrySet().iterator().next().getValue();
                }

                // sortOrder 에 따라 오름차순, 내림차순 정렬
                if (sortOrder.equals("ASC")) {
                    if (currentTarget > nextTarget) {
                        return 1;
                    } else if (currentTarget < nextTarget) {
                        return -1;
                    } else {
                        return 0;
                    }
                } else {
                    if (currentTarget > nextTarget) {
                        return -1;
                    } else if (currentTarget < nextTarget) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        };
    }
}
