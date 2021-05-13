package com.example.skillTest;

import java.net.http.HttpHeaders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan 
public class SkillTestApplication {
	
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(SkillTestApplication.class, args);  
    }
}	
