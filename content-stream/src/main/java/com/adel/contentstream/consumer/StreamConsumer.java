package com.adel.contentstream.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StreamConsumer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Transactional
    @KafkaListener(
            id = "K_WEBCRAWLER_ENTRY",
            topics = "K_WEBCRAWLER_ENTRY"
    )
    public void topicListener(final String data) {
        log.info("Received new data ...");

    }
}
