package com.pneizhmak.footapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Pavel Neizhmak
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class
})
public class FootApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootApplication.class, args);
    }
}