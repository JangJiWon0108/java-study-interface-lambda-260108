package com.jjw.study.service.impl;

import com.jjw.study.service.RandomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class RandomServiceImpl implements RandomService {

    public void randomStudy() {
        Random rd = new Random();

        // Int 랜덤 (32 비트 : -2^31 ~ 2^31-1)
        log.info("Int 랜덤");
        for (int i=0; i<3; i=i+1) {
            log.info(String.valueOf(rd.nextInt()));
        }

        // Int 범위 랜덤
        // rd.nextInt(10) -> 0~9
        // max, min 이 있다고 하면
        // rd.nextInt( (max-min)+1 ) + min
        // 만약, 5 ~ 10 이라면 rd.nextInt(6) + 5
        log.info("Int 5~10 랜덤");
        for (int i=0; i<3; i=i+1) {
            log.info(String.valueOf(rd.nextInt(6) + 5));
        }

        // Double 랜덤 (기본 범위 : 0<= <1.0)
        log.info("Double 랜덤");
        for (int i=0; i<3; i=i+1) {
            log.info(String.valueOf(rd.nextDouble()));
        }

        // Boolean 랜덤 (true, false)
        log.info("Boolean 랜덤");
        for (int i=0; i<3; i=i+1) {
            log.info(String.valueOf(rd.nextBoolean()));
        }
    }
}
