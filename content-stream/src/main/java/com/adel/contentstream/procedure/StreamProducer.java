package com.adel.contentstream.procedure;

import com.adel.contentstream.model.LogStatus;
import com.adel.contentstream.model.Logs;
import com.adel.contentstream.repository.LogsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class StreamProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final LogsRepository logsRepository;

    @Transactional
    public String sendToTopic(final String topic, final String data) {
        log.info("Send to topic " + topic + " ...");
        final Logs savedLog = Logs.builder()
                .data(data)
                .logStatus(LogStatus.PROCESS)
                .build();
        final CompletableFuture<SendResult<String, String>> sendResultCompletableFuture = kafkaTemplate.send(topic, data);
        sendResultCompletableFuture.thenAccept(r -> logsRepository.save(savedLog))
                .exceptionally(throwable -> {
                    log.error("Fail sent topic " + topic);
                    savedLog.setLogStatus(LogStatus.ERROR);
                    logsRepository.save(savedLog);
                    throw new RuntimeException(throwable.getMessage());
                });
        log.info("Done send to topic with data id " + savedLog.getId());
        return savedLog.getId();
    }

}
