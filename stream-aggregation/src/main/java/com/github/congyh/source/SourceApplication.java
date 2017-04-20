package com.github.congyh.source;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;

@EnableBinding(Source.class)
public class SourceApplication {

	@InboundChannelAdapter(value = Source.OUTPUT)
	public String greet() {
		return "hello world " + System.currentTimeMillis();
	}
}
