package org.ervan.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrontService {
    @Autowired
    MyServiceClient client;

    @HystrixCommand(fallbackMethod = "getDefaultMessage")
    public String getBase64(String input) {
        return client.getBase64(input);
    }

    private String getDefaultMessage(String input) {
        return ":) :) Service Unavailable. Please try again later (: (:";
    }
}
