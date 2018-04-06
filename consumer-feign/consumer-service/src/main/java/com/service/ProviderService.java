package com.service;

import com.model.Person;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 定义一个feign接口，通过@ FeignClient（“服务名”），来指定调用哪个服务
 * 
 * @author onlyone
 */
@FeignClient("provider-service")
public interface ProviderService {

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    String getProviderInfo(@RequestParam(value = "name") String name);

    @RequestMapping(value = "validatePeople", method = RequestMethod.POST)
    Person getProviderValidatePeople(@RequestBody Person person);
}
