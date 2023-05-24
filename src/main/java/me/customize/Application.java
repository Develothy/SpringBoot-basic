package me.customize;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.IOException;
import java.io.PrintWriter;

public class Application {

    public static void main(String[] args) throws LifecycleException {

        /**
         * 자바 코드로 내장 톰캣 만들기
         *
         * 스프링 부트 어플리케이션을 실행하면
         * 톰캣이 만들어지고 서블릿이 만들어지고 웹 MVC 설정도 잘 되고 어플리케이션이 잘 뜨게 됨
         */

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context context = tomcat.addContext("/", "/");

        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                PrintWriter writer = resp.getWriter();
                writer.println("<html><head><title>");
                writer.println("Hey, Tomcat!");
                writer.println("</title></head>");
                writer.println("<body><h1>Hello Tomcat</h1></body>");
                writer.println("</html>");
            }
        };

        String servletName = "helloServlet";
        tomcat.addServlet("/", servletName, servlet);
        context.addServletMappingDecoded("/hello", servletName);    //mapping. /hello로 진입하면 위 서블릿을 보여줌

        tomcat.start(); // 서버 올리고 종료 // 오우 서버 뜸
        tomcat.getServer().await();   // 서버가 요청을 기다림

    }
}
