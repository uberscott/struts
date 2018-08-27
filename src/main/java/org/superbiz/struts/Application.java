package org.superbiz.struts;


import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }



    @Bean
    FilterRegistrationBean struts2()
    {
        return new FilterRegistrationBean(new FilterDispatcher());
    }

    @Bean
     FilterRegistrationBean strutsCleanup()
    {
        return new FilterRegistrationBean(new ActionContextCleanUp());
    }

    @Bean
    FilterRegistrationBean sitemesh()
    {
        return new FilterRegistrationBean(new PageFilter());
    }


    /*
    <filter>
        <filter-name>struts2</filter-name>
        <filter-class>org.apache.struts2.dispatcher.FilterDispatcher</filter-class>
        <init-param>
            <param-name>actionPackages</param-name>
            <param-value>com.lq</param-value>
        </init-param>
    </filter>
    <filter>
        <filter-name>struts-cleanup</filter-name>
        <filter-class>org.apache.struts2.dispatcher.ActionContextCleanUp</filter-class>
    </filter>
    <filter>
        <filter-name>sitemesh</filter-name>
        <filter-class>com.opensymphony.module.sitemesh.filter.PageFilter</filter-class>
    </filter>

    <filter-mapping>
        <filter-name>struts-cleanup</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    <filter-mapping>
        <filter-name>sitemesh</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    <filter-mapping>
        <filter-name>struts2</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    */
}