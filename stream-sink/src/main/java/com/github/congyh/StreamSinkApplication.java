package com.github.congyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
@SpringBootApplication
public class StreamSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamSinkApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void log(String message) {
		System.out.println(message);
	}
}

