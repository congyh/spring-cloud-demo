package com.github.congyh.sink;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class SinkApplication {

	@StreamListener(Sink.INPUT)
	public void log(String message) {
		System.out.println(message);
	}
}
