package com.kk.springcloud.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by kk on 2017/12/7.
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String context){
        System.out.println("Sender : "+context);
        this.rabbitTemplate.convertAndSend("hello",context); //这里的hello是队列名称
    }

}
