package com.ezreal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *
 * @author Ezreal
 */

@SpringBootApplication
public class AopTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopTestApplication.class, args);
    }

    static class ServletInitializer extends SpringBootServletInitializer {
        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(AopTestApplication.class);
        }

    }

}
