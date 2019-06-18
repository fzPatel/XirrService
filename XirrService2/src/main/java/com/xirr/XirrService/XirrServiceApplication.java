package com.xirr.XirrService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages = "com.xirr.*")
public class XirrServiceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(XirrServiceApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(XirrServiceApplication.class, args);
    }
    
}