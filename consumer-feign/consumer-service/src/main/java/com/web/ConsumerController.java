package com.web;

import com.model.Person;
import org.bouncycastle.util.io.pem.PemObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.ProviderService;

/**
 * @author onlyone
 */
@RestController
public class ConsumerController {

    @Autowired
    ProviderService providerService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return providerService.getProviderInfo(name);
    }

    @RequestMapping(value = "validatPerson", method = RequestMethod.GET)
    public Person validatPerson(@RequestParam String name) {
        Person p = new Person();
        p.setName(name);
        return providerService.getProviderValidatePeople(p);
    }

}
