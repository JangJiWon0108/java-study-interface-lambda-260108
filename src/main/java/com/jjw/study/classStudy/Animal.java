package com.jjw.study.classStudy;

public class Animal {
    String name; // 클래스 변수. this 로 접근. this는 생성된 객체를 가리킴
    static String typeName = "동물"; // 클래스 static 변수(모든 객체에서 공유 되므로, this 사용X)

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getTypeName() {
        return typeName;
    }

    public String hello() {
        return "안녕하세요~!";
    }
}
