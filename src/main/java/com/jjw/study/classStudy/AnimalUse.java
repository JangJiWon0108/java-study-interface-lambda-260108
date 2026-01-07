package com.jjw.study.classStudy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component()
@Slf4j
public class AnimalUse {

    public Map<String, Object> animalUseTest() {
        // 1. 클래스/메서드
//        Animal dog = new Animal();
//        dog.setName("강아지");
//
//        Animal cat = new Animal();
//        cat.setName("고양이");
//
//        return Map.of(
//            "dog", Map.of("getName", dog.getName(), "getTypeName", dog.getTypeName()),
//            "cat", Map.of("getName", cat.getName(), "getTypeName", cat.getTypeName())
//        );

        // 2. 상속 기본
//        Dog dog = new Dog();
//        dog.setName("도그도그");
//        return Map.of(
//            "dog", Map.of("getName", dog.getName(), "getTypeName", dog.getTypeName())
//        );

        // 2-1. 상속 오버라이딩
//        Animal animal = new Animal();
//        animal.setName("애니멀ㅋ");
//        Dog dog = new Dog();
//        dog.setName("도그도그ㅋ");
//        return Map.of(
//                "animal", Map.of("getName", animal.getName(), "getTypeName", animal.getTypeName(), "hello", animal.hello()),
//                "dog", Map.of("getName", dog.getName(), "getTypeName", dog.getTypeName(), "hello", dog.hello())
//        );

        // 2-2. 상속 오버로딩
//        Dog dog = new Dog();
//        dog.setName("도그도그ㅋ");
//        return Map.of(
//                "dog", Map.of("getName", dog.getName(), "getTypeName", dog.getTypeName(), "hello", dog.hello(), "hello(3)", dog.hello(3))
//        );

        // 2-3. super 키워드
        Dog dog = new Dog();
        dog.setName("도그도그ㅋㅋ");
        return Map.of(
                "dog", Map.of("getName", dog.getName(), "getTypeName", dog.getTypeName(), "helloPlusBye", dog.helloPlusBye())
        );
    }
}
