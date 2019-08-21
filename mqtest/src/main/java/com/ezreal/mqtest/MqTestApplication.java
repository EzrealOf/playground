package com.ezreal.mqtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ezreal
 */
@SpringBootApplication
public class MqTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqTestApplication.class, args);
    }

    @RequestMapping(value = "hello")
    @ResponseBody
    public String helloWord(){
        return "hello word!";

    }
}
