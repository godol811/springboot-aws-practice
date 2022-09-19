package com.godol.springbootawspractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication

public class SpringbootAwsPracticeApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringbootAwsPracticeApplication.class);
        application.addListeners(new ApplicationPidFileWriter());
        application.run(args);

    }

}
