package com.jjw.study.service;

import java.util.List;
import java.util.Map;

public interface SortService {

    // For 사용 정렬
    List<Map<Integer, Integer>> sortUsingFor(String sortTarget,String sortOrder);

    // DualPivotQuick 사용 정렬
    List<Map<Integer, Integer>> sortUsingDualPivotQuickSort(String sortTarget,String sortOrder);

    // TimSort 사용 정렬
    List<Map<Integer, Integer>> sortUsingTimSort(String sortTarget,String sortOrder);

    // List 의 Sort() 메서드 사용 정렬 (Comparator 구현)
    List<Map<Integer, Integer>> sortUsingListSortComparator(String sortTarget,String sortOrder);

    // List 의 Sort() 메서드 사용 정렬 (Lambda 사용)
    List<Map<Integer, Integer>> sortUsingListSortLambda(String sortTarget,String sortOrder);
}
