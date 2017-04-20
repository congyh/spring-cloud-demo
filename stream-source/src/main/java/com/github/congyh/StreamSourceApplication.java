package com.github.congyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;

@EnableBinding(Source.class)
@SpringBootApplication
public class StreamSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamSourceApplication.class, args);
    }

    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "1000", maxMessagesPerPoll = "1"))
    public String greet() {
        return "hello world " + System.currentTimeMillis();
    }
}
