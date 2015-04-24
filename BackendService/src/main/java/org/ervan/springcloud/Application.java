package org.ervan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
@ComponentScan

public class Application {
    @RequestMapping(method = RequestMethod.GET, value = "/base64/{input}")
    public String base64(@PathVariable("input") String input) throws UnsupportedEncodingException {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return new String(Base64.encode(input.getBytes("utf-8")));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}