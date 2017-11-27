package com.kk.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kk on 2017/11/22.
 */
@RestController
@RequestMapping("/helloOne")
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value="/say")
    public Object say(){
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        logger.info("host={},port={},serviceId={}",instance.getHost(),instance.getPort(),instance.getServiceId());
        return "hello spring cloud";
    }

}
