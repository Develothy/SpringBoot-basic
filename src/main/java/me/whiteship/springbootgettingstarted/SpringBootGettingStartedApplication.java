package me.whiteship.springbootgettingstarted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/** @SpringBootApplication 은
 *  아래 3가지 어노테이션을 갖고있다.
 *  동일한 기능.
 */

@SpringBootConfiguration
@ComponentScan // @Component, @Configuration @Repository @Service @RestController
@EnableAutoConfiguration //ComponentScan이 이루어진 다음 수행(2단계)
public class SpringBootGettingStartedApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGettingStartedApplication.class, args);
    }

}
