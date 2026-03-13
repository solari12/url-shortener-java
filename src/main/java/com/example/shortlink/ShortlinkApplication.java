package com.example.shortlink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShortlinkApplication {

    public static void main(String[] args) {
        System.out.println("APP START");
        SpringApplication.run(ShortlinkApplication.class, args);
    }

}