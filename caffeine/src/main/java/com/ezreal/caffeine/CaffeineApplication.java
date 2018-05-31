package com.ezreal.caffeine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ezreal
 */
@SpringBootApplication
@Controller
@EnableCaching
public class CaffeineApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaffeineApplication.class, args);
    }

    @RequestMapping({"/hello","/"})
    @ResponseBody
    public String helloWorld(){
        return "hello World!";
    }

}
