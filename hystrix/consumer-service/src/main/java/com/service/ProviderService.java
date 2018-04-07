package com.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ProviderService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloError")
    public String hello(@RequestParam String name) {
        Map map = new HashMap();
        map.put("name", name);
        return restTemplate.getForObject("http://PROVIDER-SERVICE/getInfo?name={name}", String.class, map);
    }

    public String helloError(String name) {
        return "触发了熔断机制";
    }

}
