package main.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: dongcx
 * @Description: 方法类型
 * @Date: 2020-12-12
 **/
@Getter
@AllArgsConstructor
public enum MethodType {
    POST(1, "POST"),
    GET(2, "GET");
    private Integer key;
    private String description;
}

