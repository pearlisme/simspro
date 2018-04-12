package com.spring.sims.simspro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.spring.sims.simspro.controller")
public class SimsproApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimsproApplication.class, args);
    }
}
