package com.didispace;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    @Value("${server.port:8761}")
    private int port;

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
    //
    // @Bean
    // @Autowired
    // public EurekaInstanceConfigBean eurekaInstanceConfigBean(InetUtils inetUtils) {
    // EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(inetUtils);
    // AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
    // config.setHostname(info.get(AmazonInfo.MetaDataKey.publicHostname));
    // config.setIpAddress(info.get(AmazonInfo.MetaDataKey.publicIpv4));
    // config.setNonSecurePort(port);
    // config.setDataCenterInfo(info);
    // return config;
    // }

}
