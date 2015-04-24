package org.ervan.springcloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("back-service")
public interface MyServiceClient {
        @RequestMapping(method = RequestMethod.GET, value = "/base64/{input}")
        String getBase64(@PathVariable("input") String input);
}
