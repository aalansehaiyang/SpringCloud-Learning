package com.didispace;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PersonServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(PersonServiceApplication.class).web(true).run(args);
	}

}
