package com.kk.springcloud.controller;

import com.kk.springcloud.mq.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kk on 2017/12/7.
 */
@RestController
@RequestMapping("/mq")
public class SendMsgController {

    @Autowired
    private Sender sender;

    @RequestMapping(value = "/send")
    public Object send(@RequestParam("msg") String context){
        sender.send(context);
        return "success";
    }

}
