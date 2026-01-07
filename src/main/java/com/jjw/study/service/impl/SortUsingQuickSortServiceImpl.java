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

@Service("sortUsingQuickSort")
@RequiredArgsConstructor
@Slf4j
public class SortUsingQuickSortServiceImpl implements SortService {

    private final RandomListUtil randomListUtil;

    /**
     * QuickSort 이용한 정렬
     * @param sortTarget (KEY or VALUE)
     * @param sortOrder (ASC or DESC)
     * @return 정렬된 리스트
     */
    public List<Map<Integer, Integer>> execSort(String sortTarget, String sortOrder) {
        try {
            log.info("RUN sortUsingQuickSort");
            return sortUsingQuickSort(sortTarget, sortOrder);
        } catch (Exception e) {
            log.error("SortUsingQuickSortServiceImpl 에러 : {}", e.getMessage());
            throw e;
        }
    }

    /**
     * QuickSort 정렬을 실제로 수행하는 메서드
     * @param sortTarget 정렬 대상 (KEY 또는 VALUE)
     * @param sortOrder 정렬 순서 (ASC 또는 DESC)
     * @return 정렬된 List<Map<Integer, Integer>>
     */
    public List<Map<Integer, Integer>> sortUsingQuickSort(String sortTarget, String sortOrder) {
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

        // 퀵 정렬 수행
        quickSort(array, sortOrder);

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

    // 퀵 정렬 시작
    public static void quickSort(int[] array, String sortOrder) {
        quickSort(array, 0, array.length - 1, sortOrder);
    }

    // 재귀 수행(pivot을 중심으로 왼쪽 작은 것, 오른쪽 큰 것으로 한다)
    public static void quickSort(int[] array, int start, int end, String sortOrder) {
        int part2 = partition(array, start, end, sortOrder); // 오른쪽의 첫 번째 인덱스를 받아옴

        // 처음 위치가 오른쪽 첫 번째 인덱스 바로 다음 칸이면 왼쪽의 크기가 1이라는 뜻
        // part2 - 1 이 2 이상일 때는 왼쪽의 크기가 2 이상이라는 뜻으로 정렬을 진행한다.
        if (start < part2 - 1) {
            quickSort(array, start, part2 - 1, sortOrder);
        }
        // 오른쪽 부분의 첫 번째 시작점이 end이면 오른쪽 크기가 1이라는 뜻
        // part2 < end 는 오른쪽 크기가 2 이상이란 뜻으로 정렬을 진행한다.
        if (part2 < end) {
            quickSort(array, part2, end, sortOrder);
        }
    }

    // 배열을 나누는 부분
    public static int partition(int[] array, int start, int end, String sortOrder) {
        // 여기서 pivot은 중간 지점으로 설정
        int pivot = array[(start + end) / 2];

        // 반복문을 통해 pivot을 중심으로 왼쪽은 작은 값, 오른쪽은 큰 값이 오게 된다.
        while (start <= end) {
            // 왼쪽에서 pivot 보다 큰 값을 찾음
            while ((sortOrder.equals("ASC") ? array[start] < pivot : array[start] > pivot)) start++;

            // 오른쪽에서 pivot 보다 작은 값을 찾음
            while ((sortOrder.equals("ASC") ? array[end] > pivot : array[end] < pivot)) end--;

            // 두 개의 인덱스를 교환하고 탐색을 계속한다.
            if (start <= end) {
                swap(array, start, end);
                start++;
                end--;
            }
        }
        // while문을 반복하면 start에는 오른쪽 부분의 첫 번째 인덱스가 저장된다.
        return start;
    }

    // 배열의 2개의 위치의 값을 바꿈
    public static void swap(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
}
