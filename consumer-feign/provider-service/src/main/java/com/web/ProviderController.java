package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import com.model.Person;

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

    @RequestMapping(value = "/validatePeople", method = RequestMethod.POST)
    public Person validatePeople(@RequestBody Person person) {

        if (person.getName().equals("Tom哥")) {
            person.setResult("名字name匹配");
        } else {
            person.setResult("名字name不匹配");
        }
        return person;

    }

}
