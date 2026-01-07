package com.jjw.study.classStudy;

public class Dog extends Animal {

//    public String hello() {
//        return "안녕하세요, 오버라이딩 입니다";
//    }

    public String hello(int n) {
        return "안녕하세요, 오버로딩 입니다. n = " + n;
    }

    String helloPlusBye() {
        String helloResult = super.hello();
        return helloResult + " 안녕~잘가~";
    }
}




