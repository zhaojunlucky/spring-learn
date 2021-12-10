package com.magicworldz.springmisc;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.function.Supplier;

public class RetryUtil {
    public static <T, E extends Throwable> T retry(RetryCallback<T, E> supplier) throws Throwable {
        RetryTemplate template = new RetryTemplate();

        SimpleRetryPolicy policy = new SimpleRetryPolicy();
        policy.setMaxAttempts(3);
        template.setRetryPolicy(policy);

        return template.execute(supplier);
    }
}
