package com.jjw.study.service.impl;

import com.jjw.study.service.SortService;
import com.jjw.study.util.RandomListUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sortUsingDualPivotQuickSort")
@RequiredArgsConstructor
@Slf4j
public class SortUsingDualPivotQuickSortServiceImpl implements SortService {

    private final RandomListUtil randomListUtil;

    /**
     * DualPivotQuickSort 이용한 정렬
     * @param sortTarget (KEY or VALUE)
     * @param sortOrder (ASC or DESC)
     * @return 정렬된 리스트
     */
    public List<Map<Integer, Integer>> execSort(String sortTarget, String sortOrder) {
        try {
            log.info("RUN sortUsingDualPivotQuickSort");
            return sortUsingDualPivotQuickSort(sortTarget, sortOrder);
        } catch (Exception e) {
            log.error("SortUsingDualPivotQuickSortServiceImpl 에러 : {}", e.getMessage());
            throw e;
        }
    }

    /**
     * DualPivotQuickSort 정렬을 실제로 수행하는 메서드
     * @param sortTarget 정렬 대상 (KEY 또는 VALUE)
     * @param sortOrder 정렬 순서 (ASC 또는 DESC)
     * @return 정렬된 List<Map<Integer, Integer>>
     */
    public List<Map<Integer, Integer>> sortUsingDualPivotQuickSort(String sortTarget, String sortOrder) {
        // 예시로 숫자값을 사용하는 임의의 Map 데이터 생성
        List<Map<Integer, Integer>> dataList = randomListUtil.generateRandomList(1, 100, 100);

        // 숫자 배열로 변환 (KEY 또는 VALUE만 사용)
        int[] array = new int[dataList.size()];
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>();
        
        for (int i = 0; i < dataList.size(); i++) {
            Map<Integer, Integer> map = dataList.get(i);
            
            // Map에서 첫 번째 엔트리 가져오기 (Map.of()로 생성된 Map은 항상 하나의 엔트리만 가짐)
            Map.Entry<Integer, Integer> entry = map.entrySet().iterator().next();
            entries.add(entry);

            // KEY 또는 VALUE에 해당하는 값 추출
            Integer value = sortTarget.equals("KEY") ? entry.getKey() : entry.getValue();

            if (value != null) {
                array[i] = value; // null이 아니면 값 설정
            } else {
                array[i] = 0; // null일 경우 기본값으로 0 설정 (혹은 다른 기본값)
                log.warn("Map에서 값이 null인 항목이 발견되었습니다. 기본값 0으로 처리됩니다.");
            }
        }

        // 듀얼 피벗 퀵 정렬 수행
        dualPivotQuickSort(array, sortOrder);

        // 정렬된 데이터를 다시 List<Map<Integer, Integer>>로 변환하여 반환
        List<Map<Integer, Integer>> sortedList = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            Map.Entry<Integer, Integer> originalEntry = entries.get(i);
            int sortedValue = array[i];
            
            // 새로운 가변 Map 생성 (원본 Map이 불변이므로)
            Map<Integer, Integer> newMap = new HashMap<>();
            if (sortTarget.equals("KEY")) {
                // KEY로 정렬: 정렬된 KEY와 원본 VALUE 사용
                newMap.put(sortedValue, originalEntry.getValue());
            } else {
                // VALUE로 정렬: 원본 KEY와 정렬된 VALUE 사용
                newMap.put(originalEntry.getKey(), sortedValue);
            }
            sortedList.add(newMap);
        }

        return sortedList;
    }

    // 듀얼 피벗 퀵 정렬 시작
    public static void dualPivotQuickSort(int[] array, String sortOrder) {
        dualPivotQuickSort(array, 0, array.length - 1, sortOrder);
    }

    // 재귀 수행(피벗 2개를 설정하여 영역을 정렬)
    public static void dualPivotQuickSort(int[] array, int low, int high, String sortOrder) {
        if (low < high) {
            // high 큰 값, low 작은 값으로 설정
            if (sortOrder.equals("ASC") ? array[low] > array[high] : array[low] < array[high]) {
                swap(array, low, high);
            }

            int pivot1 = array[low];
            int pivot2 = array[high];
            int lt = low + 1; // 피벗1보다 작은 요소들의 경계
            int gt = high - 1; // 피벗2보다 큰 요소들의 경계
            int i = low + 1; // 현재 검사 중인 요소

            // p1 시작점, p2 끝점
            // p1과 p2 사이를 탐색하면서 p1보다 작으면 왼쪽으로 보내고 p2보다 크면 오른쪽으로 보낸다.
            // 이 과정에서 lt++, gt-- 과정이 이루어진다.
            // 탐색을 마치면 p1, p2를 위치를 재조정한다.
            // 같은 과정을 반복한다.
            while (i <= gt) {
                if (sortOrder.equals("ASC")) {
                    if (array[i] < pivot1) {
                        swap(array, i++, lt++);
                    } else if (array[i] > pivot2) {
                        swap(array, i, gt--);
                    } else {
                        i++;
                    }
                } else {
                    if (array[i] > pivot1) {
                        swap(array, i++, lt++);
                    } else if (array[i] < pivot2) {
                        swap(array, i, gt--);
                    } else {
                        i++;
                    }
                }
            }

            swap(array, low, --lt);
            swap(array, high, ++gt);

            // 재귀적으로 정렬
            dualPivotQuickSort(array, low, lt - 1, sortOrder);
            dualPivotQuickSort(array, lt + 1, gt - 1, sortOrder);
            dualPivotQuickSort(array, gt + 1, high, sortOrder);
        }
    }

    // 배열의 2개의 위치의 값을 바꿈
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}

