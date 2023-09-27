package com.seleniumexpress.lc;

import com.seleniumexpress.lc.config.LoveCalculatorConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class LoveCalculatorApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
         System.out.println("WebApplicationInitializer");

//       XmlWebApplicationContext appContext = new XmlWebApplicationContext();
//       appContext.setConfigLocation("/WEB-INF/application-config.xml");

        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(LoveCalculatorConfig.class);

        ServletRegistration.Dynamic dispatcher =
               servletContext.addServlet("dispatcher", new DispatcherServlet(webApplicationContext));
       dispatcher.setLoadOnStartup(1);
       dispatcher.addMapping("/");

       /*

       Doubts:
       Why

       1)  dispatcher.addMapping("/"); -> Will also work
       http://localhost:8080/spring_love_calculator_war_exploded/  -> Hello World!
       http://localhost:8080/spring_love_calculator_war_exploded/test -> This is content in JSP FIle

       2) dispatcher.addMapping("mywebsite.com/*"); -> Will Work

       3) dispatcher.addMapping("/*"); -> Wont work
       Error:
       19-Sep-2023 21:02:45.254 WARNING [http-nio-8080-exec-7] org.springframework.web.servlet.DispatcherServlet.noHandlerFound No mapping for GET /spring_love_calculator_war_exploded/WEB-INF/view/hello-world.jsp




        */


    }
}
