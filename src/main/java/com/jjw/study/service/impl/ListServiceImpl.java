package com.jjw.study.service.impl;

import com.jjw.study.service.ListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ListServiceImpl implements ListService {

    public void listStudy() {
        // 빈 ArrayList 선언
        List<String> myList = new ArrayList<>();

        // add(e) : 마지막에 추가
        myList.add("사과");
        myList.add("1 번째 요소");
        myList.add("2 번째 요소");
        myList.add("3 번째 요소");
        myList.add("4 번째 요소");
        myList.add("5 번째 요소");
        myList.add("사과");
        log.info("myList : {}\n", myList);

        // get(index) : 해당 인덱스 값 리턴
        log.info("get(1) : {}\n", myList.get(1));

        // add(index, e) : 해당 인덱스에 삽입
        myList.add(1, "삽입합니다");
        log.info("add(1, 삽입합니다) myList : {}\n", myList);

        // set(index, e) : 해당 인덱스를 해당 값으로 변경
        myList.set(1, "new 1 번째 요소");
        log.info("set(1, new 1 번째 요소) myList : {}\n", myList);

        // size() : 크기 반환
        log.info("size : {}", myList.size());

        // remove(index) : 해당 인덱스값 삭제 후, 삭제된 요소를 반환
        log.info("remove(1) 반환값 : {}", myList.remove(1));
        log.info("myList : {}\n", myList);

        // remove(e) : 해당 값 제거 (첫번째 하나 제거, 제거 - true, 실패 - false 반환
        log.info("remove(5 번째 요소) 반환값 : {}", myList.remove("5 번째 요소"));
        log.info("remove(100 번째 요소) 반환값 : {}", myList.remove("100 번째 요소"));
        log.info("myList : {}\n", myList);

        // isEmpty() : 비어있는지 여부
        log.info("isEmpty : {}", myList.isEmpty());

        // contains(e) : 요소가 있는지 여부
        log.info("contains 1 번째 요소 : {}", myList.contains("1 번째 요소"));
        log.info("contains 100 번째 요소 : {}", myList.contains("100 번째 요소"));

        // indexOf(e) : 요소의 인덱스 반환(가장 처음), 없으면 -1
        log.info("indexOf(사과) : {}", myList.indexOf("사과"));
        log.info("indexOf(100 번째 요소) : {}", myList.indexOf("100 번째 요소"));

        // lastIndexOf(e) : 요소의 인덱스 반환(가장 마지막), 없으면 -1
        log.info("lastIndexOf(사과) : {}", myList.lastIndexOf("사과"));
        log.info("lastIndexOf(100 번째 요소) : {}", myList.lastIndexOf("100 번째 요소"));

        // clear() : 모든 요소 제거함
        myList.clear();
        log.info("myList : {}\n", myList);
    }
}
