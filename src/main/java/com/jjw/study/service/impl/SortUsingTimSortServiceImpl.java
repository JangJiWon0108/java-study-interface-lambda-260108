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

@Service("sortUsingTimSort")
@RequiredArgsConstructor
@Slf4j
public class SortUsingTimSortServiceImpl implements SortService {

    private final RandomListUtil randomListUtil;

    // 런의 크기 설정
    private static final int RUN = 32;

    /**
     * TimSort 이용한 정렬
     * @param sortTarget (KEY or VALUE)
     * @param sortOrder (ASC or DESC)
     * @return 정렬된 리스트
     */
    public List<Map<Integer, Integer>> execSort(String sortTarget, String sortOrder) {
        try {
            log.info("RUN sortUsingTimSort");
            return sortUsingTimSort(sortTarget, sortOrder);
        } catch (Exception e) {
            log.error("SortUsingTimSortServiceImpl 에러 : {}", e.getMessage());
            throw e;
        }
    }

    /**
     * TimSort 정렬을 실제로 수행하는 메서드
     * @param sortTarget 정렬 대상 (KEY 또는 VALUE)
     * @param sortOrder 정렬 순서 (ASC 또는 DESC)
     * @return 정렬된 List<Map<Integer, Integer>>
     */
    public List<Map<Integer, Integer>> sortUsingTimSort(String sortTarget, String sortOrder) {
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

        // Tim 정렬 수행
        timSort(array, sortOrder);

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

    // Tim 정렬 시작
    public static void timSort(int[] array, String sortOrder) {
        int n = array.length;

        // 런 크기에 따라 배열을 여러 부분으로 나누고 각 부분에 대해 삽입 정렬 수행한다.
        for (int i = 0; i < n; i += RUN) {
            insertionSort(array, i, Math.min((i + RUN - 1), n - 1), sortOrder);
        }

        // 런들을 병합
        // RUN이 2라면 처음에는 크기가 2인 런들을 병합한다.
        // 그 이후 4, 8, 16인 런들을 병합한다.
        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1; // 첫 번째 런의 마지막 인덱스
                int right = Math.min((left + 2 * size - 1), (n - 1)); // 두 번째 런의 마지막 인덱스

                if (mid < right) { // 두런이 겹치지 않을 경우에 병합을 수행
                    merge(array, left, mid, right, sortOrder);
                }
            }
        }
    }

    // 삽입 정렬
    public static void insertionSort(int[] array, int left, int right, String sortOrder) {
        for (int i = left + 1; i <= right; i++) {
            // 탐색하는 값이 앞의 값보다 작으면 위치를 바꿈
            // 즉, 앞의 값이 작을 때까지 계속 앞으로 보내서 정렬시킴
            int temp = array[i];
            int j = i - 1;

            if (sortOrder.equals("ASC")) {
                while (j >= left && array[j] > temp) {
                    array[j + 1] = array[j];
                    j--;
                }
            } else {
                while (j >= left && array[j] < temp) {
                    array[j + 1] = array[j];
                    j--;
                }
            }
            array[j + 1] = temp;
        }
    }

    // 배열의 두 부분을 병합하는 메소드
    public static void merge(int[] array, int l, int m, int r, String sortOrder) {
        // 병합할 두 부분 배열의 크기를 찾는다.
        int len1 = m - l + 1;
        int len2 = r - m;

        int[] left = new int[len1];
        int[] right = new int[len2];

        // 데이터를 임시 배열로 복사
        System.arraycopy(array, l, left, 0, len1);
        System.arraycopy(array, m + 1, right, 0, len2);

        // 병합 과정
        int i = 0; // left 인덱스
        int j = 0; // right 인덱스
        int k = l; // 병합 될 배열의 인덱스

        if (sortOrder.equals("ASC")) {
            while (i < len1 && j < len2) {
                if (left[i] <= right[j]) {
                    array[k++] = left[i++];
                } else {
                    array[k++] = right[j++];
                }
            }
        } else {
            while (i < len1 && j < len2) {
                if (left[i] >= right[j]) {
                    array[k++] = left[i++];
                } else {
                    array[k++] = right[j++];
                }
            }
        }

        // 남은 요소 복사
        while (i < len1) {
            array[k++] = left[i++];
        }
        while (j < len2) {
            array[k++] = right[j++];
        }
    }
}
