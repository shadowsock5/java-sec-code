package org.joychou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@ServletComponentScan // do filter
@SpringBootApplication
// @EnableEurekaClient  // 测试Eureka请打开注释，防止控制台一直有warning
//public class Application extends SpringBootServletInitializer {    // Spring boot 1.5.1.RELEASE的写法
public class Application {   // Spring boot 2.6.6 的写法

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}