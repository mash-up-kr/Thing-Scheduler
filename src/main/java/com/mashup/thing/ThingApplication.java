package com.mashup.thing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ThingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThingApplication.class, args);
    }

}
