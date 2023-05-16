package me.whiteship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DogRunner implements ApplicationRunner {

    /** Dog는 만든적이 없는데? -> 외부 프로젝트 주입
     *  외부 프로젝트에서 lifecycle > install
     *  해당 프로젝트에서 dependency 등록 후 주입받아서 사용
     *  (External Libraries에 추가되어있다.)
     */
    @Autowired
    Dog dog;
    // 외부 플젝에 dog 세팅값을 불러오거나, properties로 관리 한다면 해당 값을 불러오게 되어있음.

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(dog);
    }
}
