package com.jjw.study.service;

import java.util.List;
import java.util.Map;

/**
 * SortService 함수형 인턴페이스
 * 추상 메서드 1개 존재 : execSort
 */
@FunctionalInterface
public interface SortService {

    // sortTarget(정렬 기준)과 sortOrder(정렬 순서)를 받아 정렬 후 결과 List를 return 하는 추상 메서드
    List<Map<Integer, Integer>> execSort(String sortTarget,String sortOrder);
}
