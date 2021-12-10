package com.magicworldz.springmisc;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

public class RetryTest {
    @Retryable(value = { RuntimeException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    public String retry() {
        System.out.println("retry");
        throw new RuntimeException("retry");
    }
}
