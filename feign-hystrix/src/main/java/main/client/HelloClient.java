package main.client;

import main.config.HelloFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2021-01-23
 **/
@FeignClient(url = "http://localhost:8080", name = "hello-client", configuration = HelloFeignConfig.class)
public interface HelloClient {
    @GetMapping("/hello/test0001")
    String getResult();

}
