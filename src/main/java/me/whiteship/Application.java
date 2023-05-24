package me.whiteship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/** @SpringBootApplication 은
 *  아래 3가지 어노테이션을 갖고있다.
 *  동일한 기능.
 */

@SpringBootConfiguration
@ComponentScan // 빈으로 등록된 것들을 읽어들임. @Component, @Configuration @Repository @Service @RestController
@EnableAutoConfiguration // ComponentScan이 이루어진 다음 수행(2단계)
public class Application {

    public static void main(String[] args) {
        /** 스프링부트는 웹서버가 아니고
         *  내장 서블릿 컨테이너 스프링프레임워크를 쉽게 사용할 수 있게 해주는 일종의 툴
         *    - 서버 : 톰캣, 네티, 제, 언더토
         *  아래 코드는 웹 애플리케이션 없이 가동
         */
        // SpringApplication.run(SpringBootGettingStartedApplication.class, args);
        SpringApplication application = new SpringApplication(Application.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

    /** 외부 플젝에 dog 세팅값을 불러오거나, properties로 관리 한다면 해당 값을 불러오게 되어있음.
     * 그냥 run()하면
     *  - The bean 'dog', defined in me.whiteship.Application
     *  - Consider renaming one of the beans
     *  해결 >> or enabling overriding by setting spring.main.allow-bean-definition-overriding=true (프로퍼티스에 추가)
     *
     *     -- @ConditionalOnMissingBean 을 외부 @Bean Dog에 붙여서 해당 타입의 bean이 없을 때만 config하는 방식도 있었으나,
     *        스프링 부트 버전이 올라가면서 현재는 이 어노테이션으로 빈 재정의 허용X
     *
     *  properties 와 아래  @Bean 직접등록이 있는데 직접 등록한 빈이 덮어쓴다. 이긴다!
     **/
/*    @Bean
    public Dog dog() {
        Dog dog = new Dog();
        dog.setName("momo");
        dog.setAge(5);
        return dog;
    }*/

}
