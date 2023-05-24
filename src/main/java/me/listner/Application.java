package me.listner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    /**
     * 실행 시 portlistener에 설정한 포트 출력이 호출
     * 인포 로그의 포트와 동일한지 확인해보자. -> OK
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
