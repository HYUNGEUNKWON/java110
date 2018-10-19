package bitcamp.java110.cms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java110.cms.AppConfig;

public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener.contextInitialized() 실행!");
        
        ServletContext sc = sce.getServletContext();

        try {
            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            
            // 서블릿에서 Service를 이용할 수 있도록 ServletContext 보관소에 저장하기
            sc.setAttribute("iocContainer", context);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}







