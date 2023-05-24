package me.listner;

import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PortListener implements ApplicationListener<ServletWebServerInitializedEvent> {

    /**
     * ServletWebServerInitializedEvent가 생성이되면 해당 이벤트리스너가 호출됨.
     * 웹서버 어플리케이션 컨텍스트는 웹서버를 알 수 있고 웹서버는 포트를 알 수 있다.
     */

    @Override
    public void onApplicationEvent(ServletWebServerInitializedEvent event) {
        ServletWebServerApplicationContext applicationContext = event.getApplicationContext();
        System.out.println(applicationContext.getWebServer().getPort());
    }
}
