package com.ezreal.service;

import com.ezreal.config.MyProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class Send {

    @Autowired
    private MyProcessor processor;

    @StreamListener(MyProcessor.INPUT)
    public void routeValues(Integer val) {
       processor.myOutput().send(message(val));
    }

    private static final <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val).build();
    }
}
