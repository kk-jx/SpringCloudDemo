package com.kk.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by kk on 2017/11/26.
 */
@Service
public class HelloService {
    private static Logger logger = LoggerFactory.getLogger(HelloService.class);

    @Autowired
    private RestTemplate restTemp;

    @HystrixCommand(fallbackMethod = "helloFallBack")
    public Object helloService(){
        Long start = System.currentTimeMillis();
        String result = restTemp.getForEntity("http://HELLO-SERVICE/hello/say",String.class).getBody();
        Long end = System.currentTimeMillis();
        logger.info("访问HELLO-SERVICE服务耗时：{}",end-start);
        return result;
    }

    public Object helloFallBack(){
        return "熔断保护 helloFallBack";
    }

}
