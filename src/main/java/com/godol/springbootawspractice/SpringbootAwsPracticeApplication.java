package com.godol.springbootawspractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringbootAwsPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAwsPracticeApplication.class, args);
    }

}
