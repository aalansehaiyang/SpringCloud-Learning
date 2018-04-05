package com.didispace.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final Logger    logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/get_user_info", method = RequestMethod.GET)
    public Person add(@RequestParam(name = "name") String name) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());

        Person p = new Person();
        p.setName(name);
        p.setAge(28);
        p.setAddress("浙江省杭州市西湖区");
        return p;
    }

    static class Person {

        private String  name;
        private Integer age;
        private String  address;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

    }

}
