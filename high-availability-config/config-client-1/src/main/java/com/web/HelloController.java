package com.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {

    @Value("${diamond.v}")
    private String v;

    /**
     * 获取远程github系统中的配置属性值
     */
    @RequestMapping("/v")
    public String getValue() {
        return v;
    }
}
