package com.adel.contentstream.model;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@RedisHash("logs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Logs implements Serializable {

    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @Builder.Default
    private Date createdAt = new Date();

    private String topic;

    private String data;

    private LogStatus logStatus;

}
