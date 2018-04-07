package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Autowired
    private DiscoveryClient client;

    @Value("${server.port}")
    String                  port;

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public String getInfo(@RequestParam String name) {
        ServiceInstance instance = client.getLocalServiceInstance();
        String s = "hello，%s,host:%s,service_id:%s,port:%s";
        return String.format(s, name, instance.getHost(), instance.getServiceId(), port);
    }

}
