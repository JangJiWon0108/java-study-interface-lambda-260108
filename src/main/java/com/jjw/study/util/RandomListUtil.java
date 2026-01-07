package com.jjw.study.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
@RequiredArgsConstructor
@Slf4j
public class RandomListUtil {

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
