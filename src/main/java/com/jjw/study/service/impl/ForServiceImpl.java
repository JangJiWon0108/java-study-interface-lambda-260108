package com.jjw.study.service.impl;

import com.jjw.study.service.ForService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ForServiceImpl implements ForService {

    public void forStudy() {
        // List 생성
        List<String> myList1 = new ArrayList<>();
        List<String> myList2 = new ArrayList<>();

        myList1.add("사과");
        myList1.add("딸기");
        myList1.add("포도");

        myList2.add("라면");
        myList2.add("초밥");
        myList2.add("치킨");

        // 일반 For 문
        for(int i=0; i<myList1.size(); i=i+1) {
            log.info("i={}, myList1.get(i) = {}", i, myList1.get(i));
        }

        // 이중 For 문
        for(int i=0; i<myList1.size(); i=i+1) {
            log.info("=== 바깥 for문 ===");
            log.info("i={}, myList1.get(i) = {}", i, myList1.get(i));

            for (int j = 0; j < myList2.size(); j = j + 1) {
                log.info("=== 안쪽 for문 ===");
                log.info("j={}, myList2.get(j) = {}", j, myList2.get(j));
            }
        }

        // 일반 For 문 - 요소 변경
        for(int i=0; i<myList1.size(); i=i+1) {
            myList1.set(i, "수박");
        }
        log.info("일반 For문, '수박' 으로 모두 변경 : {}\n", myList1);

        // 향상된 For 문
        log.info("향상된 for문 myList2 순회");
        for (String value : myList2) {
            log.info(value);
        }

        // 향상된 For 문 - 요소 변경
        // value 라는 임시변수에 복사해서 처리하므로, 원본에 접근하는것이 아니다. 따라서 변경되지 않음
        for (String value : myList2) {
            value = "육회비빔밥";
        }
        log.info("향상된 for문 요소 변경 시도 후 : {}", myList2);

        // 향상된 For 문 - iterator 기반
        // 컴파일러 최적화를 통해 이터레이터 기반으로 동작함
        // 위에서 작성한 향상된 for문은 아래와 같음
        Iterator<String> iter = myList2.iterator();
        while(iter.hasNext()) {
            log.info((String) iter.next());
        }
    }
}
