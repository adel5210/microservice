package com.adel.contentstream;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableKafka
@EnableScheduling
@EnableAsync
@RequiredArgsConstructor
@EnableRetry
@Slf4j
public class ContentStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentStreamApplication.class, args);
    }

}
