package com.jjw.study.service.impl;

import com.jjw.study.service.MapService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class MapServiceImpl implements MapService {

    public void mapStudy() {
        // 빈 HashMap 선언
        Map<String, Object> myMap = new HashMap<>();

        // put(key, value) - 추가
        myMap.put("key1", "value1");
        myMap.put("key2", "value2");
        myMap.put("key3", "value3");
        myMap.put("key4", "value4");

        // get(key) - 해당 key에 대응되는 value 반환. 없다면 null 반환
        log.info("get key1 : {}", myMap.get("key1"));
        log.info("get key5 : {}\n", myMap.get("key5"));

        // (key, defaultValue) - 해당 key가 없을때의 반환값(기본값) 설정 가능
        log.info("getOrDefault key1 : {}", myMap.getOrDefault("key1", "key1 default value"));
        log.info("getOrDefault key5 : {}\n", myMap.getOrDefault("key5", "key5 default value"));

        // entrySet 및 getKey(), getValue() 로 순환하기
        log.info("entrySet 및 getKey(), getValue() 로 순환하기");
        for (Map.Entry<String, Object> entry : myMap.entrySet()) {
            log.info("key : {}, value : {}", entry.getKey(), entry.getValue());
        }

        // containsKey(key) - 해당 key를 포함하고 있는지 여부
        log.info("containsKey key1 : {}", myMap.containsKey("key1"));
        log.info("containsKey key5 : {}\n", myMap.containsKey("key5"));

        // containsValue(value) - 해당 value 를 포함하고 있는지 여부
        log.info("containsValue value1 : {}", myMap.containsValue("value1"));
        log.info("containsValue value5 : {}\n", myMap.containsValue("value5"));

        // size() - 개수
        log.info("size : {}\n", myMap.size());

        // isEmpty() - 비어있는지 여부
        log.info("isEmpty : {}\n", myMap.isEmpty());

        // keySet() - key로만 만들어진 set 객체 반환
        log.info("keySet : {}\n", myMap.keySet());

        // remove(key) - 해당 key 값 삭제
        myMap.remove("key1");
        log.info("remove key1");
        log.info("containsKey key1  : {}", myMap.containsKey("key1"));
        log.info("myMap 전체 : {}\n", myMap);

        // remove(key, value) - 해당 key:value 쌍 삭제
        myMap.remove("key2", "value100");
        log.info("remove key2:value100");
        log.info("containsKey key2  : {}", myMap.containsKey("key2"));
        log.info("myMap 전체 : {}", myMap);
        log.info("myMap size : {}\n", myMap.size());

        myMap.remove("key2", "value2");
        log.info("remove key2:value2");
        log.info("containsKey key2  : {}", myMap.containsKey("key2"));
        log.info("myMap 전체 : {}", myMap);
        log.info("myMap size : {}\n", myMap.size());

        // replace(key, value) - 해당 key 값을 value 로 대체함
        myMap.replace("key3", "new value3");
        log.info("replace key3:new value3 : {}\n", myMap.get("key3"));

        // replace(key, old, new) - 해당 key:old 쌍의 값을 old->new 로 대체함
        myMap.replace("key4", "value100", "new value4");
        log.info("replace [key4, value100, new value4] : {}\n", myMap.get("key4"));

        myMap.replace("key4", "value4", "new value4");
        log.info("replace [key4, value4, new value4] : {}\n", myMap.get("key4"));
    }
}
