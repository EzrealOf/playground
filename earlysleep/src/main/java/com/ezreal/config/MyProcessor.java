package com.ezreal.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Service;

@Service
public interface MyProcessor {
    String INPUT = "myInput";
    String OUTPUT = "myOutput";

    @Input
    SubscribableChannel myInput();

    @Output("myOutput")
    MessageChannel myOutput();


}
