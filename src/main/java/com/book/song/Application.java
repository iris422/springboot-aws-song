package com.book.song;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성 자동 설정됨
// 프로젝트 최상단 위치 필수!!
@SpringBootApplication  
public class Application {
    public static void main(String[] args) {
        // 내장 WAS 실행
        SpringApplication.run(Application.class, args);
    }
}
