package com.sample.demoapplication;

import com.sample.demoapplication.model.PostResponse;
import com.sample.demoapplication.service.SampleService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private SampleService service;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) {
        PostResponse postResponse = service.update().get(3);
        JSONObject obj = new JSONObject();

        obj.put("id", postResponse.getId());
        obj.put("userId", postResponse.getUserId());
        obj.put("title", postResponse.getTitle());
        obj.put("body", postResponse.getBody());
        System.out.print(obj);
    }
}
