package com.adel.contentstream.retryable;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RetryService {

    @Retryable(
            recover = "recoverCallback",
            value={IOException.class},
            maxAttempts = 3,
            backoff = @Backoff(delay = 1000, multiplier = 1.5)
    )
    public void rerun(){

    }

    @Recover
    public void recoverCallback(IOException e){

    }

}
