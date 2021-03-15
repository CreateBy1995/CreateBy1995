package main.controller;

import main.client.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2021-01-23
 **/
@RestController
@RequestMapping("/feign")
public class FeignController {
    @Autowired
    private HelloClient helloClient;

    @GetMapping(value = "/test001")
    public String test001() {
        try {
            Class customClass = Thread.currentThread().getContextClassLoader().loadClass("main.CustomClass");
            System.out.println(customClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "feign" + helloClient.getResult();
    }
}
