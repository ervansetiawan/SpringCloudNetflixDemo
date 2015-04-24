package org.ervan.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
@EnableCircuitBreaker
@EnableHystrix
@ComponentScan
@EnableFeignClients
@EnableZuulProxy

public class Application {
    @Autowired
    FrontService service;

    @RequestMapping(method = RequestMethod.GET, value = "/base64/{input}")
    public String base64(@PathVariable("input") String input) {
        return service.getBase64(input);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}