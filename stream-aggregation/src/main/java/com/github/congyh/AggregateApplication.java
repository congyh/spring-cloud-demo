package com.github.congyh;

import com.github.congyh.sink.SinkApplication;
import com.github.congyh.source.SourceApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.aggregate.AggregateApplicationBuilder;

/**
 * @author <a href='mailto:yihao.cong@outlook.com'>Cong Yihao</a>
 */
@SpringBootApplication
public class AggregateApplication {

    public static void main(String[] args) {
        new AggregateApplicationBuilder()
            .from(SourceApplication.class).namespace("source").args("--fixedDelay=5000")
            .to(SinkApplication.class).namespace("sink")
            .run(args);
    }

}
