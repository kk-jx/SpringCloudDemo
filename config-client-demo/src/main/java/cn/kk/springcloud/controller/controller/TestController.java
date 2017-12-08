package cn.kk.springcloud.controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kk on 2017/11/28.
 */
@RestController
public class TestController {
    @Value("${from}")
    private String from;

    @Autowired
    private Environment env;

    @GetMapping(value="/from")
    public Object from(){
        String env_from = env.getProperty("from","undefined");
        return this.from+"    "+env_from;
    }

}
