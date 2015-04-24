package org.ervan.springcloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://api.icndb.com/jokes/random?exclude=[nerdy,explicit]")
public interface ChuckNorrisClient {
    @RequestMapping(method = RequestMethod.GET, value = "/joke")
    String joke();
}
