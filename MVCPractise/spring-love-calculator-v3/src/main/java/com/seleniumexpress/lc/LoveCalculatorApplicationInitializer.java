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


    }
}
