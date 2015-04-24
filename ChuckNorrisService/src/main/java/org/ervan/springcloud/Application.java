package org.ervan.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@RestController
@EnableDiscoveryClient
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
    @Autowired
    private ChuckNorrisClient client;

    @RequestMapping("/joke")
    public String home() {
        return client.joke();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
