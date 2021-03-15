package main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2021-01-23
 **/
@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    @GetMapping(value = "/test0001")
    public String test001() {
        return "test001";
    }

}
